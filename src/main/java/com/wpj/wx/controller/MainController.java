/*
 * Copyright (c) 2015 - 10 - 22  7 : 22 :55
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/22.
 */
@RestController
@RequestMapping("/main")
public class MainController extends BaseController {
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public Object getMainUIMessage(@RequestBody List<String> list,String callbackparam){
        MyLogeer.info(MYTAG,list.toString());
//        for(Map.Entry<String,Object> entry:map.entrySet()){
//            MyLogeer.info(MYTAG,"key="+entry.getKey()+"\n "+"value="+entry.getValue());
//        }

        return super.toClient(callbackparam,list);
    }
}
