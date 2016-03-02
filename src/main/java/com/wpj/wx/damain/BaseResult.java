/*
 * Copyright (c) 2016 - 2 - 25  9 : 24 :11
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.damain;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/******************************************************
 * ****** Created by 吴培基 on 2015/7/20.19:40
 * ****************************************************
 */
public class BaseResult implements Serializable {
    // 返回码，0表示成功，非0表示失败
    private HttpStatus resultCode;

    // 返回消息，成功为“success”，失败为具体失败信息
    private String resultMessage;

    // 返回数据
    private Object resultData;

    public BaseResult(HttpStatus resultCode, String resultMessage, Object resultData) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.resultData = resultData;
    }

    public BaseResult(HttpStatus resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public HttpStatus getResultCode() {
        return resultCode;
    }

    public void setResultCode(HttpStatus resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public BaseResult()
    {

    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "resultCode=" + resultCode +
                ", resultMessage='" + resultMessage + '\'' +
                ", resultData=" + resultData +
                '}';
    }
}
