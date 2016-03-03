/*
 * Copyright (c) 2016 - 1 - 27  10 : 47 :47
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.admin.slider;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wpj.wx.aop.Procedure;
import com.wpj.wx.common.Config;
import com.wpj.wx.controller.common.BaseController;
import com.wpj.wx.util.FileUploadConfiguration;
import com.wpj.wx.util.FileUploadHelper;
import com.wpj.wx.util.ImagesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Name：SliderAdminController
 * Time：2016/1/27 22:47
 * author：WPJ587
 * description：轮播控制器
 **/
@Controller
@RequestMapping(value = "/admin")
@ApiIgnore
public class SliderAdminController extends BaseController {
    @Autowired
    private FileUploadConfiguration fileUploaderConfiguration;
    @RequestMapping(value = {"/slider"})
    @Procedure(description = "访问轮播")
    public String toSlider(ModelMap map){
        MyLogeer.info("访问slider");
        map.addAttribute("MyTemplate","admin/module/slider/sliderIndex.vm");
        return Config.INDEX;
    }
    @RequestMapping(value = {"/slider/add"})
    @Procedure(description = "添加轮播")
    public String addSlider(ModelMap map){
        MyLogeer.info("添加了");
        map.addAttribute("MyTemplate","admin/module/slider/sliderAdd.vm");
        return Config.INDEX;
    }
    @RequestMapping("/slider/upload")
    @ResponseBody
    @Procedure(description = "上传")
    public String upload(@RequestParam(value = "upload", required = false) MultipartFile file,
                         HttpServletRequest request, ModelMap model){

        String fileName = FileUploadHelper.getUniqueName(file.getOriginalFilename());
        File targetFile = new File(fileUploaderConfiguration.getSliderPath(), fileName);
       File path=new File(fileUploaderConfiguration.getSliderPath());
        if(!path.exists()){
            path.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            String waterStr=new String(fileUploaderConfiguration.getWaterName().getBytes("ISO8859-1"),"UTF-8");
            ImagesUtils.pressText(fileUploaderConfiguration.getSliderPath() + fileName, waterStr, "宋体", Font.BOLD, 20, Color.gray, 0, 0, 0.5f);
        } catch (UnsupportedEncodingException e) {
            MyLogeer.error("发生错误 {}",e.getCause());
            return "-1";
           // e.printStackTrace();
        } catch (IOException e) {
            MyLogeer.error("发生错误{}",e.getCause());
            return "-1";
        }
        return "1";
    }
}
