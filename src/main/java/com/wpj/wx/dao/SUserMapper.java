/*
 * Copyright (c) 2016 - 3 - 3  2 : 19 :41
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.dao;

import com.wpj.wx.daomain.SUser;
import com.wpj.wx.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface SUserMapper extends MyMapper<SUser> {
    SUser selectUserBySuser(@Param("sUser") SUser sUser);
}