/*
 * Copyright (c) 2016 - 3 - 3  2 : 19 :18
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.daomain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "persistent_logins")
public class PersistentLogins extends BaseDamain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String series;

    private String username;

    private String token;

    @Column(name = "last_used")
    private Date lastUsed;

    /**
     * @return series
     */
    public String getSeries() {
        return series;
    }

    /**
     * @param series
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return last_used
     */
    public Date getLastUsed() {
        return lastUsed;
    }

    /**
     * @param lastUsed
     */
    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
}