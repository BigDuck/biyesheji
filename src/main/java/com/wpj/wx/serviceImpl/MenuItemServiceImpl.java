/*
 * Copyright (c) 2016 - 2 - 16  10 : 6 :34
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.wpj.wx.daomain.TbMenuitem;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.MenuItemService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Name：MenuItemServiceImpl
 * Time：2016/2/16 22:06
 * author：WPJ587
 * description：子菜单
 **/
@Service
public class MenuItemServiceImpl extends BaseService<TbMenuitem> implements MenuItemService {
    @Override
    @Cacheable(value = "myCache",key = "'menuitem'+#page+'-'+#rows")
    public List<TbMenuitem> getMenuByPage(TbMenuitem tbMenuitem, int page, int rows) {
        Example example = new Example(TbMenuitem.class);
        Example.Criteria criteria = example.createCriteria();
        if (tbMenuitem.getMenuitemId()!=null) {
            criteria.andEqualTo("menuitemId",tbMenuitem.getMenuitemId());
        }
        if(tbMenuitem.getMenuId()!=null){
            criteria.andEqualTo("menuId",tbMenuitem.getMenuId());
        }
        if(tbMenuitem.getTitle()!=null){
            criteria.andEqualTo("title",tbMenuitem.getTitle());
        }
        //分页查询
        PageHelper.startPage(page, rows);

        return selectByExample(example);
    }
}
