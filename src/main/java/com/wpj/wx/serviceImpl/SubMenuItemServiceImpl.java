/*
 * Copyright (c) 2016 - 2 - 26  10 : 53 :6
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceimpl;

import com.wpj.wx.damain.TbSubmenuitem;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.SubMenuItemService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Name：SubMenuItemServiceImpl
 * Time：2016/2/26 10:52
 * author：WPJ587
 * description：子菜单业务实体类
 **/
@Service
public class SubMenuItemServiceImpl extends BaseService<TbSubmenuitem> implements SubMenuItemService {
    /**
     * 根据子菜单获取子菜单数据
     *
     * @param tbSubmenuitem
     * @return
     */
    @Override
    @Cacheable(value = "myCache",key = "#tbSubmenuitem")
    public List<TbSubmenuitem> getSubItemByTbSubmenuItem(TbSubmenuitem tbSubmenuitem) {
        Example example = new Example(TbSubmenuitem.class);
        Example.Criteria criteria = example.createCriteria();
        if(tbSubmenuitem==null){
            return null;
        }
        if(tbSubmenuitem.getMenuitemId()!=null){
            criteria.andEqualTo("menuitemId",tbSubmenuitem.getMenuitemId());
        }
        if(tbSubmenuitem.getSubId()!=null){
            criteria.andEqualTo("subId",tbSubmenuitem.getSubId());
        }
        return selectByExample(example);
    }
}
