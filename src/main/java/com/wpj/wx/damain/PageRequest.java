/*
 * Copyright (c) 2016 - 1 - 23  3 : 14 :26
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.damain;

import java.util.Date;

/**
 * Name：PageRequest
 * Time：2016/1/23 15:14
 * author：WPJ587
 * description：分页请求参数
 **/

public class PageRequest  extends BaseDamain {
    /**
     * 页号
     */
    private int page=1;
    /**
     * 每页大小
     */
    private int rows=10;
    /**
     * 开始时间，用于时间范围查询
     */
    private Date startTime;
    /**
     * 结束时间 用于时间范围查询
     */
    private Date endTime=new Date();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
