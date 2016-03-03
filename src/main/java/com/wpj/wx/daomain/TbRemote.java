/*
 * Copyright (c) 2016 - 3 - 3  2 : 19 :18
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.daomain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_remote")
public class TbRemote extends BaseDamain{
    /**
     * 时间加ip地址
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 调用的ip
     */
    @Column(name = "remote_ip")
    private String remoteIp;

    /**
     * 被调用的次数
     */
    @Column(name = "remote_count")
    private Long remoteCount;

    @Column(name = "remote_date")
    private Date remoteDate;

    /**
     * 获取时间加ip地址
     *
     * @return id - 时间加ip地址
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置时间加ip地址
     *
     * @param id 时间加ip地址
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取调用的ip
     *
     * @return remote_ip - 调用的ip
     */
    public String getRemoteIp() {
        return remoteIp;
    }

    /**
     * 设置调用的ip
     *
     * @param remoteIp 调用的ip
     */
    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    /**
     * 获取被调用的次数
     *
     * @return remote_count - 被调用的次数
     */
    public Long getRemoteCount() {
        return remoteCount;
    }

    /**
     * 设置被调用的次数
     *
     * @param remoteCount 被调用的次数
     */
    public void setRemoteCount(Long remoteCount) {
        this.remoteCount = remoteCount;
    }

    /**
     * @return remote_date
     */
    public Date getRemoteDate() {
        return remoteDate;
    }

    /**
     * @param remoteDate
     */
    public void setRemoteDate(Date remoteDate) {
        this.remoteDate = remoteDate;
    }
}