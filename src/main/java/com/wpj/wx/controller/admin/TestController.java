/*
 * Copyright (c) 2015 - 11 - 17  0 : 38 :25
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Name：TestController
 * Time：2015/11/17 12:38
 * author：WPJ587
 * description：测试用的无意义
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String tesxt(){
//       TestController.class;
//       TestController.class;
//       TestController.class;
//       TestController.class;

        System.out.println("true = " + true);
        test("ind");
//       TestController.class;
//       TestController.class;
        return "index";
    }

    /**
     * 你好测试
     * @param id 没关系是ID
     */
    public static void test(String id){
        String a="";
    }
}
