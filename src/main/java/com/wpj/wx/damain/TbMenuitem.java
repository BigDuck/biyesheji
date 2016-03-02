/*
 * Copyright (c) 2015 - 10 - 14  9 : 53 :35
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.damain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.List;

@Table(name = "tb_menuitem")
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)//自动忽略空字段
public class TbMenuitem  extends BaseDamain {
    @Id
    @Column(name = "menuItem_id")
    @JsonIgnore
    private Integer menuitemId;

    @Column(name = "Link")
    private String link;

    @Column(name = "Menu_id")
    @JsonIgnore
    private Integer menuId;
    @Column(name = "title")
    private String title;

    @Column(name = "subCols")
    private Integer subCols;
    @Transient
    List<TbSubmenuitem> subMenu;

    public Integer getMenuitemId() {
        return menuitemId;
    }

    public void setMenuitemId(Integer menuitemId) {
        this.menuitemId = menuitemId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSubCols() {
        return subCols;
    }

    public void setSubCols(Integer subCols) {
        this.subCols = subCols;
    }

    public List<TbSubmenuitem> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<TbSubmenuitem> subMenu) {

        this.subMenu = subMenu;
    }
}