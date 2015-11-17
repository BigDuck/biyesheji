/*
 * Copyright (c) 2015 - 10 - 17  8 : 26 :33
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WPJ587 on 2015/10/17.
 */
@Controller
public class BaseController {
    protected Logger MyLogeer= LoggerFactory.getLogger(this.getClass().getName());
    protected String MYTAG=this.getClass().getName();
    public Object toClient(String callbackParam,Object object){
        if(callbackParam==null){

            return object;
        }else {
            return new JSONPObject(callbackParam,object);
        }
    }
}
