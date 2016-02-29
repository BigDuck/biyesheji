/*
 * Copyright (c) 2015 - 10 - 13  10 : 34 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.daomain;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Table(name = "tb_header")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段
public class TbHeader extends BaseDamain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "class_id")
    @Max(32)
    private String classId;
    @Max(32)
    private String theme;
    @Max(4)
    private boolean fixed;
    @Max(100)
    @Column(name = "Left_link")
    private String leftLink;
    @Max(100)
    @Column(name = "Right_link")
    private String rightLink;
    @Max(10)
    @Column(name = "Left_title")
    private String leftTitle;
    @Max(10)
    @Column(name = "Right_title")
    private String rightTitle;
    @Max(50)
    @Column(name = "Left_icon")
    private String leftIcon;
    @Max(50)
    @Column(name = "right_icon")
    private String rightIcon;
    @Max(32)
    @Column(name = "Left_class_Name")
    private String leftClassName;
    @Max(32)
    @Column(name = "right_class_Name")
    private String rightClassName;
    @Max(100)
    private String other;
    @NotNull
    @Max(20)
    @Column(name = "Title")
    private String title;

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
     * @return class_id
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @param classId
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * @return theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * @param theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * @return fixed
     */
    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    /**
     * @return Left_link
     */
    public String getLeftLink() {
        return leftLink;
    }

    /**
     * @param leftLink
     */
    public void setLeftLink(String leftLink) {
        this.leftLink = leftLink;
    }

    /**
     * @return Right_link
     */
    public String getRightLink() {
        return rightLink;
    }

    /**
     * @param rightLink
     */
    public void setRightLink(String rightLink) {
        this.rightLink = rightLink;
    }

    /**
     * @return Left_title
     */
    public String getLeftTitle() {
        return leftTitle;
    }

    /**
     * @param leftTitle
     */
    public void setLeftTitle(String leftTitle) {
        this.leftTitle = leftTitle;
    }

    /**
     * @return Right_title
     */
    public String getRightTitle() {
        return rightTitle;
    }

    /**
     * @param rightTitle
     */
    public void setRightTitle(String rightTitle) {
        this.rightTitle = rightTitle;
    }

    /**
     * @return Left_icon
     */
    public String getLeftIcon() {
        return leftIcon;
    }

    /**
     * @param leftIcon
     */
    public void setLeftIcon(String leftIcon) {
        this.leftIcon = leftIcon;
    }

    /**
     * @return right_icon
     */
    public String getRightIcon() {
        return rightIcon;
    }

    /**
     * @param rightIcon
     */
    public void setRightIcon(String rightIcon) {
        this.rightIcon = rightIcon;
    }

    /**
     * @return Left_class_Name
     */
    public String getLeftClassName() {
        return leftClassName;
    }

    /**
     * @param leftClassName
     */
    public void setLeftClassName(String leftClassName) {
        this.leftClassName = leftClassName;
    }

    /**
     * @return right_class_Name
     */
    public String getRightClassName() {
        return rightClassName;
    }

    /**
     * @param rightClassName
     */
    public void setRightClassName(String rightClassName) {
        this.rightClassName = rightClassName;
    }

    /**
     * @return other
     */
    public String getOther() {
        return other;
    }

    /**
     * @param other
     */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TbHeader{" +
                "id=" + id +
                ", classId='" + classId + '\'' +
                ", theme='" + theme + '\'' +
                ", fixed=" + fixed +
                ", leftLink='" + leftLink + '\'' +
                ", rightLink='" + rightLink + '\'' +
                ", leftTitle='" + leftTitle + '\'' +
                ", rightTitle='" + rightTitle + '\'' +
                ", leftIcon='" + leftIcon + '\'' +
                ", rightIcon='" + rightIcon + '\'' +
                ", leftClassName='" + leftClassName + '\'' +
                ", rightClassName='" + rightClassName + '\'' +
                ", other='" + other + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}