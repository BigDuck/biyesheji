package com.wpj.wx.daomain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Table(name = "tb_submenuitem")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段
public class TbSubmenuitem extends BaseDamain{
    @Id
    @Column(name = "Sub_id")
    @JsonIgnore
    private Integer subId;

    @Column(name = "Sub_link")
    private String link;

    @Column(name = "Sub_title")
    private String title;

    @Column(name = "menuItem_id")
    @JsonIgnore
    private Integer menuitemId;
    @Column(name = "Sub_htmlName")
    private String className;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMenuitemId() {
        return menuitemId;
    }

    public void setMenuitemId(Integer menuitemId) {
        this.menuitemId = menuitemId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}