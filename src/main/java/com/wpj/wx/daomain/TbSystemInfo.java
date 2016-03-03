/*
 * Copyright (c) 2016 - 3 - 3  2 : 19 :18
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.daomain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_system_info")
public class TbSystemInfo extends BaseDamain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String osname;

    private String ip;

    private String hostname;

    private Long cpunumber;

    private double cpuratio;

    private Long phymemory;

    private Long phyfreememory;

    private String diskmemory;

    private Long jvmtotalmemory;

    private Long jvmfreememory;

    private Long jvmmaxmemory;

    private Long gccount;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return osname
     */
    public String getOsname() {
        return osname;
    }

    /**
     * @param osname
     */
    public void setOsname(String osname) {
        this.osname = osname;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return cpunumber
     */
    public Long getCpunumber() {
        return cpunumber;
    }

    /**
     * @param cpunumber
     */
    public void setCpunumber(Long cpunumber) {
        this.cpunumber = cpunumber;
    }

    /**
     * @return cpuratio
     */
    public double getCpuratio() {
        return cpuratio;
    }

    /**
     * @param cpuratio
     */
    public void setCpuratio(double cpuratio) {
        this.cpuratio = cpuratio;
    }

    /**
     * @return phymemory
     */
    public Long getPhymemory() {
        return phymemory;
    }

    /**
     * @param phymemory
     */
    public void setPhymemory(Long phymemory) {
        this.phymemory = phymemory;
    }

    /**
     * @return phyfreememory
     */
    public Long getPhyfreememory() {
        return phyfreememory;
    }

    /**
     * @param phyfreememory
     */
    public void setPhyfreememory(Long phyfreememory) {
        this.phyfreememory = phyfreememory;
    }

    /**
     * @return diskmemory
     */
    public String getDiskmemory() {
        return diskmemory;
    }

    /**
     * @param diskmemory
     */
    public void setDiskmemory(String diskmemory) {
        this.diskmemory = diskmemory;
    }


    /**
     * @return jvmtotalmemory
     */
    public Long getJvmtotalmemory() {
        return jvmtotalmemory;
    }

    /**
     * @param jvmtotalmemory
     */
    public void setJvmtotalmemory(Long jvmtotalmemory) {
        this.jvmtotalmemory = jvmtotalmemory;
    }

    /**
     * @return jvmfreememory
     */
    public Long getJvmfreememory() {
        return jvmfreememory;
    }

    /**
     * @param jvmfreememory
     */
    public void setJvmfreememory(Long jvmfreememory) {
        this.jvmfreememory = jvmfreememory;
    }

    /**
     * @return jvmmaxmemory
     */
    public Long getJvmmaxmemory() {
        return jvmmaxmemory;
    }

    /**
     * @param jvmmaxmemory
     */
    public void setJvmmaxmemory(Long jvmmaxmemory) {
        this.jvmmaxmemory = jvmmaxmemory;
    }

    /**
     * @return gccount
     */
    public Long getGccount() {
        return gccount;
    }

    /**
     * @param gccount
     */
    public void setGccount(Long gccount) {
        this.gccount = gccount;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}