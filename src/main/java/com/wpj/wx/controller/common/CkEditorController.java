/*
 * Copyright (c) 2015 - 12 - 21  11 : 33 :7
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.controller.common;

import com.wpj.wx.util.FileUploadConfiguration;
import com.wpj.wx.util.FileUploadHelper;
import com.wpj.wx.util.ImagesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Name：CkEditorController
 * Time：2015/12/21 23:32
 * author：WPJ587
 * description：CkEditor 富文本编辑器上传图片控制类
 **/
@Controller
@RequestMapping("/uploads")
public class CkEditorController extends BaseController {
    @Autowired
    private FileUploadConfiguration fileUploaderConfiguration;

    /**
     * 图片上传和添加文字水印
     * @param request  httprequest对象
     * @param response httpresponse对象
     * @param file 上传的文件
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Object upload(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam(value = "upload", required = false)  MultipartFile file) throws IOException {


        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        // CKEditor提交的很重要的一个参数
        String callback = request.getParameter("CKEditorFuncNum");
        String expandedName = ""; // 文件扩展名
        String uploadContentType = file.getContentType();
        MyLogeer.info(uploadContentType);
        if (uploadContentType.equals("image/jpeg")
                || uploadContentType.equals("image/jpeg")) {
            // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
            expandedName = ".jpg";
        } else if (uploadContentType.equals("image/png")
                || uploadContentType.equals("image/x-png")) {
            // IE6上传的png图片的headimageContentType是"image/x-png"
            expandedName = ".png";
        } else if (uploadContentType.equals("image/gif")) {
            expandedName = ".gif";
        } else if (uploadContentType.equals("image/bmp")) {
            expandedName = ".bmp";
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
                    + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
            out.println("</script>");
            return null;
        }
        if (file.getSize() > 1024 * 1024 * 2) {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
                    + ",''," + "'文件大小不得大于2m');");
            out.println("</script>");
            return null;
        }

        String path = fileUploaderConfiguration.getPathToUploadFolder();
        String fileName = FileUploadHelper.getUniqueName(file.getOriginalFilename());
        //        String fileName = new Date().getTime()+".jpg";
        File targetFile = new File(path + fileName);
        try {
            file.transferTo(targetFile);
            String waterStr=new String(fileUploaderConfiguration.getWaterName().getBytes("ISO8859-1"),"UTF-8");
            ImagesUtils.pressText(path + fileName, waterStr, "宋体", Font.BOLD, 20, Color.gray, 0, 0, 0.5f);
            MyLogeer.error("水印名字:{}",waterStr);
        } catch (Exception e) {
            MyLogeer.error("添加水印失败{}", e.getCause());
        }

        // 返回"图像"选项卡并显示图片 request.getContextPath()为web项目名
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
                + ",'" + request.getContextPath() + "/images/"
                + fileName + "','')");
        out.println("</script>");
        return null;
    }
}
