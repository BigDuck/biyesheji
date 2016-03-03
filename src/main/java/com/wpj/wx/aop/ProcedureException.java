/*
 * Copyright (c) 2016 - 1 - 21  11 : 0 :33
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.aop;

@SuppressWarnings("serial")
public class ProcedureException extends Exception {
	
	private final int statusCode;
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public String getStatusMessage() {
		return super.getMessage();
	}
	
	public ProcedureException( int code) {
		super(""); // select with statusMessage.properties
		this.statusCode = code;
	}
	
	public ProcedureException( int code, Throwable cause) {
		super("" ,cause);  // select with statusMessage.properties
		this.statusCode = code;
	}
	
	public ProcedureException( int code, String message) {
		super(message);
		this.statusCode = code;
	}
	
	public ProcedureException( int code, String message, Throwable cause) {
		super(message, cause);
		this.statusCode = code;
	}
}
