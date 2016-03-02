/*
 * Copyright (c) 2016 - 2 - 29  7 : 25 :46
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx;

import com.wpj.wx.damain.SUser;
import com.wpj.wx.service.SUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Name：securityTest
 * Time：2016/2/29 19:25
 * author：WPJ587
 * description：
 **/
//@Rollback(value = false)
public class securityTest extends BaseTest {
    @Autowired
    SUserService sUserService;
    @Test
    public void insertUser(){
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
        SUser sUser=new SUser();
        sUser.setEmail("757671834@qq.com");
        sUser.setName("吴培基");
        sUser.setPassword(bc.encode("123456789"));
//        SRole sRole=new SRole();
//        sRole.setName("admin");
//        Set role=new HashSet();
//        role.add(sRole);
//        sUser.setSRoles(role);
        sUserService.save(sUser);

    }
    @Test
    public  void login(){
        SUser sUser=new SUser();
        sUser.setEmail("757671834@qq.com");
     SUser sUser1= sUserService.loginAndAuth(sUser);
        System.out.println(sUser1);
    }

}
