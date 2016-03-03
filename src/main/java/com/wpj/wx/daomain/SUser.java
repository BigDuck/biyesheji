/*
 * Copyright (c) 2016 - 3 - 3  2 : 19 :18
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.daomain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "s_user")
public class SUser extends BaseDamain {
    private static final long serialVersionUID = -5452498690888953945L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private String password;

    private Date dob;
    @Transient
    private Set<SRole> SRoles = new HashSet<SRole>(0);

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Set<SRole> getSRoles() {
        return SRoles;
    }

    public void setSRoles(Set<SRole> SRoles) {
        this.SRoles = SRoles;
    }

    public SUser() {
    }

    public SUser(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                ", SRoles=" + SRoles +
                '}';
    }
}