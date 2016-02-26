/*
 * Copyright (c) 2016 - 1 - 21  11 : 0 :13
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.aop;

import com.google.common.base.Strings;
import com.wpj.wx.daomain.TbIplogs;
import com.wpj.wx.service.IpLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * The type Procedure aspect.
 */
@Component
@Aspect
public class ProcedureAspect {
private Logger logger= LoggerFactory.getLogger(ProcedureAspect.class);
	/**
	 * The Ip log service.
	 */
	@Autowired
	IpLogService ipLogService;

	/**
	 * Target methods.
	 */
	@Pointcut("execution(* com.wpj.wx.aop.*.*(..)) ")
	public void targetMethods() {}

	/**
	 * Pre handle.
	 *
	 * @param joinPoint the join point
	 */
	@Before("@annotation(com.wpj.wx.aop.Procedure)")
	public void preHandle(JoinPoint joinPoint) {
		logger.info("info:----------------------------------------------------------->before");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		//读取session中的用户
	//	logger.info("name---------->"+ SecurityTools.getUserName());
		//请求的IP
		TbIplogs tbIplogs=new TbIplogs();
		String ip = request.getRemoteAddr();

		logger.info("ip----------->"+ip);
		tbIplogs.setIp(ip);
		tbIplogs.setCreateTime(new Date());

		tbIplogs.setUrl(request.getRequestURI());
		logger.info("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
		StringBuffer params=new StringBuffer();
		for (Object o:joinPoint.getArgs()){
			if(!Strings.isNullOrEmpty(o+"")){
				params.append("-"+o.toString());
			}
			logger.info("参数:{}",o);
		}


		try {
			tbIplogs.setParams(joinPoint.getSignature().getName() + "()"+params.toString()+getControllerMethodDescription(joinPoint));
			logger.info("方法描述:" + getControllerMethodDescription(joinPoint));

			ipLogService.save(tbIplogs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Post handle.
	 *
	 * @param retVal the ret val
	 */
	@AfterReturning(
			pointcut="@annotation(com.wpj.wx.aop.Procedure)",
			returning="retVal")
	public void postHandle(Object retVal) {
		logger.info("Aspect :: postHandle, retVal={}");
	}

	/**
	 * Handle object.
	 *
	 * @param pjp the pjp
	 * @return the object
	 */
	@Around("@annotation(com.wpj.wx.aop.Procedure)")
	public Object handle(ProceedingJoinPoint pjp) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		Calendar ca = Calendar.getInstance();
		String operDate = df.format(ca.getTime());
		logger.info(operDate+"------------");
		logger.info("Aspect :: around - start");
		Object[] args;
		try {
			args = pjp.getArgs();
			System.out.println(args == null ? pjp.proceed() : pjp.proceed(args));
			return args == null ? pjp.proceed() : pjp.proceed(args);
		} catch (Throwable e) {
			logger.info("Aspect :: handleException");
			int statusCode = 500;
			e.printStackTrace();
			String statusMessage = "unknown";
			if (e instanceof ProcedureException) {
				statusCode = ((ProcedureException) e).getStatusCode();
				statusMessage = ((ProcedureException) e).getStatusMessage();
			} else if (e instanceof IllegalArgumentException) {
				statusCode = 400;
				statusMessage = "Invalid parameter";
			}
			Output<Object> error = new Output<Object>(UUID.randomUUID().toString(), statusCode, statusMessage);
			return error;
		} finally {
			logger.info("Aspect :: around - end");
		}
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param joinPoint 切点
	 * @return 方法描述 controller method description
	 * @throws Exception the exception
	 */
	public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(Procedure.class).description();
					break;
				}
			}
		}
		return description;
	}

}
