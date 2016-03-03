/*
 * Copyright (c) 2016 - 2 - 29  3 : 59 :59
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.exception;

import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.daomain.BaseResult;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyExceptionHandler extends BaseController {

   @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Object handleResourceNotFoundError(HttpServletRequest request,ResourceNotFoundException ex) {
      MyLogeer.error("找不到页面了");
      return "404";
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResult handleUnexpectedServerError(HttpServletRequest request,RuntimeException ex) {

        return null;
    }
}