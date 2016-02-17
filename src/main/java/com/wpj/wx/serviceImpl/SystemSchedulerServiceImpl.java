/*
 * Copyright (c) 2016 - 1 - 23  4 : 33 :41
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceImpl;

import com.wpj.wx.daomain.TbSystemInfo;
import com.wpj.wx.service.SystemInfoService;
import com.wpj.wx.service.SystemSchedulerService;
import com.wpj.wx.util.SystemOSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Name：SystemSchedulerServiceImpl
 * Time：2016/1/23 16:33
 * author：WPJ587
 * description：系统定时调度
 * * cron表达式：*(秒0-59) *(分钟0-59) *(小时0-23) *(日期1-31) *(月份1-12或是JAN-DEC) *(星期1-7或是SUN-SAT)
 **/
@Component
public class SystemSchedulerServiceImpl implements SystemSchedulerService {
    private static Logger logger = LoggerFactory.getLogger(SystemSchedulerServiceImpl.class);
    @Autowired
    SystemInfoService systemInfoService;

    //    @Scheduled(cron = "0/5 * *  * * ? ")
    @Scheduled(fixedRate = 1000 * 60*60*24 )//24小时检测一次
    @Override
    public void writeSystemInfo() {
        TbSystemInfo tbSystemInfo = new TbSystemInfo();
        tbSystemInfo.setOsname(SystemOSUtils.getOsName());
        tbSystemInfo.setIp(SystemOSUtils.getOsLocalHostIp());
        tbSystemInfo.setCpunumber((long) SystemOSUtils.getOsCpuNumber());
        tbSystemInfo.setCpuratio(SystemOSUtils.getOscpuRatio());
        tbSystemInfo.setCreateTime(new Date());
        try {
            tbSystemInfo.setDiskmemory(SystemOSUtils.getfile().toString());
        } catch (Exception e) {
            logger.info("定时任务失败",e.getCause());
        }
        tbSystemInfo.setGccount(SystemOSUtils.getJvmGcCount());
        tbSystemInfo.setHostname(SystemOSUtils.getOsLocalHostName());
        tbSystemInfo.setJvmfreememory(SystemOSUtils.getJvmFreeMemory());
        tbSystemInfo.setJvmmaxmemory(SystemOSUtils.getJvmMaxMemory());
        tbSystemInfo.setJvmtotalmemory(SystemOSUtils.getJvmTotalMemory());
        tbSystemInfo.setPhyfreememory(SystemOSUtils.getOsPhysicalFreeMemory());
        tbSystemInfo.setPhymemory(SystemOSUtils.getOsPhysicalMemory());
        systemInfoService.save(tbSystemInfo);
        logger.info("定时任务成功开始....");
    }
}
