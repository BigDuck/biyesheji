/*
 * Copyright (c) 2015 - 10 - 18  9 : 35 :18
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于弥补json输出返回的时候无法正确格式化时间问题
 *
 */
public class MyDateSerializer extends JsonSerializer<Date> {
  @Override
  public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    jgen.writeString(formatter.format(value));
  }
}