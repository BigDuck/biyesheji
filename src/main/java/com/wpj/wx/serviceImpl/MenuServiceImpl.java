/*
 * Copyright (c) 2015 - 10 - 14  9 : 48 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.wpj.wx.dao.TbMenuMapper;
import com.wpj.wx.damain.TbMenu;
import com.wpj.wx.damain.TbMenuitem;
import com.wpj.wx.damain.TbSubmenuitem;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.MenuItemService;
import com.wpj.wx.service.MenuService;
import com.wpj.wx.service.SubMenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    @Autowired
    MenuItemService menuItemService;
    @Autowired
    SubMenuItemService subMenuItemService;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    @Cacheable(value = "myCache",key = "'mmsg'+#menuId")
    public TbMenu findAllMenuMessageById(int menuId) {
        // 根据菜单的id再去获取子菜单
        TbMenu tbMenu = tbMenuMapper.selectAllMenuMessageById(menuId);
        TbMenuitem tbMenuitem = new TbMenuitem();
        tbMenuitem.setMenuId(tbMenu.getMenuId());
        List<TbMenuitem> menuitem = menuItemService.getMenuByPage(tbMenuitem, 1, 20);
        logger.info("result:>{}", menuitem);
        for (int j = 0; j < tbMenu.getContent().size(); j++) {
            logger.error("subMenu长度:" + tbMenu.getContent().get(j).getSubMenu().size());
            if (tbMenu.getContent().get(j).getSubMenu().size() < 1) {
                tbMenu.getContent().get(j).setSubMenu(null);
            } else {
                TbSubmenuitem tbSubmenuitem = new TbSubmenuitem();
                tbSubmenuitem.setMenuitemId(tbMenu.getContent().get(j).getMenuitemId());
                tbMenu.getContent().get(j).setSubMenu(subMenuItemService.getSubItemByTbSubmenuItem(tbSubmenuitem));
            }

        }
       // tbMenu.setContent(menuitem);
        logger.info("---------->{}", tbMenu);
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
