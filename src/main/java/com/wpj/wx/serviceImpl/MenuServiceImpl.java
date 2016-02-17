/*
 * Copyright (c) 2015 - 10 - 14  9 : 48 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.wpj.wx.dao.TbMenuMapper;
import com.wpj.wx.daomain.TbMenu;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by WPJ587 on 2015/10/14.
 */
@Service
public class MenuServiceImpl extends BaseService<TbMenu> implements MenuService {
    @Autowired
    TbMenuMapper tbMenuMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public TbMenu findAllMenuMessageById(int menuId) {
        TbMenu tbMenu = tbMenuMapper.selectAllMenuMessageById(menuId);
        for (int j = 0; j < tbMenu.getContent().size(); j++) {
            logger.error("subMenu长度:" + tbMenu.getContent().get(j).getSubMenu().size());

            if (tbMenu.getContent().get(j).getSubMenu().size() == 1) {
                tbMenu.getContent().get(j).setSubMenu(null);
            }
        }

        return tbMenu;
    }

    @Override
    public List<TbMenu> getMenuByPage(TbMenu tbMenu, int page, int rows) {
        Example example = new Example(TbMenu.class);
        Example.Criteria criteria = example.createCriteria();
        if (tbMenu.getId() != null) {
            criteria.andEqualTo("Menu_Id", tbMenu.getId());
        }
        if (tbMenu.getMenuName() != null) {
            criteria.andEqualTo("menu_name", tbMenu.getMenuName());
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }
}
