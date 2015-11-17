/*
 * Copyright (c) 2015 - 10 - 13  10 : 46 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.wpj.wx.dao.TbHeaderMapper;
import com.wpj.wx.serviceImpl.HeaderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by WPJ587 on 2015/10/12.
 */
@RestController
@RequestMapping("/headers")
public class HeaderController extends BaseController {
    private Logger logger= LoggerFactory.getLogger(HeaderController.class);
    @Autowired
    HeaderServiceImpl headerServiceImp;
    @Autowired
    TbHeaderMapper tbHeaderMapper;
    @RequestMapping(value = "/header/{headerId}",method = RequestMethod.GET)
    @ResponseBody
    public Object getHeader(@PathVariable("headerId")int headerId,String callbackparam){
        Map<String,Object> map=headerServiceImp.findDataMapById(headerId);
        logger.info("map-->"+map);
        return  super.toClient(callbackparam,map);
    }


}
