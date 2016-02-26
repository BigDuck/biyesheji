/*
 * Copyright (c) 2016 - 1 - 21  11 : 0 :33
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.aop;

/**
 * The type Procedure exception.
 */
@SuppressWarnings("serial")
public class ProcedureException extends Exception {
	
	private final int statusCode;

	/**
	 * Gets status code.
	 *
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Gets status message.
	 *
	 * @return the status message
	 */
	public String getStatusMessage() {
		return super.getMessage();
	}

	/**
	 * Instantiates a new Procedure exception.
	 *
	 * @param code the code
	 */
	public ProcedureException( int code) {
		super(""); // select with statusMessage.properties
		this.statusCode = code;
	}

	/**
	 * Instantiates a new Procedure exception.
	 *
	 * @param code  the code
	 * @param cause the cause
	 */
	public ProcedureException( int code, Throwable cause) {
		super("" ,cause);  // select with statusMessage.properties
		this.statusCode = code;
	}

	/**
	 * Instantiates a new Procedure exception.
	 *
	 * @param code    the code
	 * @param message the message
	 */
	public ProcedureException( int code, String message) {
		super(message);
		this.statusCode = code;
	}

	/**
	 * Instantiates a new Procedure exception.
	 *
	 * @param code    the code
	 * @param message the message
	 * @param cause   the cause
	 */
	public ProcedureException( int code, String message, Throwable cause) {
		super(message, cause);
		this.statusCode = code;
	}
}
