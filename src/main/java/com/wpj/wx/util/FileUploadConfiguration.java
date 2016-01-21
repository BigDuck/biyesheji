

/*
 * Copyright (c) 2015 - 12 - 21  11 : 40 :2
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 用来读取存放上（application）传文件的路径
 */
public class FileUploadConfiguration {
    /**
     *上传图片存放的路径
     */
    private String pathToUploadFolder;
    /**
     * 文字水印名字
     */
    private String waterName;

    public String getWaterName() {
        return waterName;
    }

    public void setWaterName(String waterName) {
        this.waterName = waterName;
    }

    public String getPathToUploadFolder() {
        return pathToUploadFolder;
    }

    public void setPathToUploadFolder(String pathToUploadFolder) {
        this.pathToUploadFolder = pathToUploadFolder;
    }
}
