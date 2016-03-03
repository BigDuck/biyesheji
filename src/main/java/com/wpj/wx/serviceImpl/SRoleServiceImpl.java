/*
 * Copyright (c) 2016 - 3 - 3  4 : 27 :0
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceImpl;

import com.wpj.wx.dao.SRoleMapper;
import com.wpj.wx.daomain.SRole;
import com.wpj.wx.daomain.SUser;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.SRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Name：SRoleServiceImpl
 * Time：2016/3/3 16:26
 * author：WPJ587
 * description：权限
 **/
@Service
public class SRoleServiceImpl extends BaseService<SRole> implements SRoleService {
    @Autowired
private  SRoleMapper sRoleMapper;
    @Override
    public List<SRole> findByUser(SRole sRole) {
        Example example=new Example(SRole.class);
        Example.Criteria criteria=example.createCriteria();
        if(sRole==null){
            sRole=new SRole();
        }
        if(sRole.getId()!=null){
            criteria.andEqualTo("id",sRole.getId());
        }  if(sRole.getUid()!=null){
            criteria.andEqualTo("uid",sRole.getUid());
        }  if(sRole.getName()!=null){
            criteria.andEqualTo("name",sRole.getName());
        }
        return sRoleMapper.selectByExample(example);
    }
}
