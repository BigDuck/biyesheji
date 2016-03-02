/*
 * Copyright (c) 2015 - 10 - 13  10 : 46 :$second
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wpj.wx.aop.Procedure;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.damain.BaseResult;
import com.wpj.wx.serviceimpl.HeaderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
/**
 * Created by WPJ587 on 2015/10/12.
 */
@RestController
@RequestMapping("/headers")
@Api(basePath = "/headers", value = "Header", description = "网站标题")
public class HeaderController extends BaseController {
    private Logger logger= LoggerFactory.getLogger(HeaderController.class);
    /**
     * The Header service imp.
     */
    @Autowired
    HeaderServiceImpl headerServiceImp;

    /**
     * Gets header.
     *
     * @param headerId      the header id
     * @param callbackparam the callbackparam
     * @param request       the request
     * @return the header
     */
    @RequestMapping(value = "/header/{headerId}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据id编号获取网站标题信息",notes = "获取标题", httpMethod="GET",response = BaseResult.class)
    @Procedure(description = "获取网站标题")
    @PreAuthorize("")
    public Object getHeader(@ApiParam(required = true, name = "headerId", value = "headerId id Integer")
                                @PathVariable("headerId")int headerId,
                            String callbackparam, HttpServletRequest request){

        Map<String,Object> map=headerServiceImp.findDataMapById(headerId);
        logger.info("map-->"+map);
        return  super.toClient(callbackparam,map);
    }


}
