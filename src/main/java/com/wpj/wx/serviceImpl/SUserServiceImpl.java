/*
 * Copyright (c) 2016 - 2 - 29  4 : 41 :6
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.serviceimpl;

import com.wpj.wx.dao.SUserMapper;
import com.wpj.wx.damain.SUser;
import com.wpj.wx.service.BaseService;
import com.wpj.wx.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Name：SUserServiceImpl
 * Time：2016/2/29 16:40
 * author：WPJ587
 * description：登陆用户业务
 */
@Service
public class SUserServiceImpl extends BaseService<SUser> implements SUserService {
    @Autowired
    private SUserMapper sUserMapper;

    public SUser login(String email, String password) {
        Example example = new Example(SUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (email != null) {
            criteria.andEqualTo("email", email);
        }
        if (password != null) {
            criteria.andEqualTo("password", password);
        }
        List<SUser> sUserList = selectByExample(example);
        SUser result = null;
        if (sUserList != null && sUserList.size() == 1) {
            result = sUserList.get(0);
        }
        return result;
    }

    @Override
    public List<SUser> findSUser(SUser sUser) {

        Example example = new Example(SUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (sUser.getEmail() != null) {
            criteria.andEqualTo("email", sUser.getEmail());
        }
        if (sUser.getPassword() != null) {
            criteria.andEqualTo("password", sUser.getPassword());
        }
        if (sUser.getName() != null) {
            criteria.andEqualTo("name", sUser.getName());
        }
        return selectByExample(example);
    }

    /**
     * 登录验证
     *
     * @param sUser
     * @return
     */
    @Override
    public SUser loginAndAuth(SUser sUser) {
        if (sUser==null){
            return null;
        }
        return sUserMapper.selectUserBySuser(sUser);
    }

}
