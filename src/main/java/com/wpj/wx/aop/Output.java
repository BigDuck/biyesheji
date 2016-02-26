/*
 * Copyright (c) 2016 - 1 - 21  11 : 0 :51
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx.aop;

/**
 * The type Output.
 *
 * @param <T> the type parameter
 */
public class Output<T> {
	
	private String trxId;
	private int statusCode;
	private String statusMessage;
	private T data;

	/**
	 * Instantiates a new Output.
	 *
	 * @param trxId         the trx id
	 * @param statusCode    the status code
	 * @param statusMessage the status message
	 */
	public Output(String trxId, int statusCode, String statusMessage) {
		this.trxId = trxId;
		this.statusCode = statusCode;
		this.statusMessage = "";
	}

	/**
	 * Instantiates a new Output.
	 *
	 * @param trxId the trx id
	 * @param data  the data
	 */
	public Output(String trxId, T data) {
		this.trxId = trxId;
		this.statusCode = 200;
		this.data = data;
		this.statusMessage = "";
	}

	/**
	 * Gets trx id.
	 *
	 * @return the trx id
	 */
	public String getTrxId() {
		return trxId;
	}

	/**
	 * Sets trx id.
	 *
	 * @param trxId the trx id
	 */
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	/**
	 * Gets status code.
	 *
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets status code.
	 *
	 * @param statusCode the status code
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets status message.
	 *
	 * @return the status message
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * Sets status message.
	 *
	 * @param statusMessage the status message
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * Gets data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets data.
	 *
	 * @param data the data
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	public String toString() {
		return new StringBuilder().append("@").append(this.trxId).append("-[")
				.append(this.statusCode).append(": ")
				.append(this.statusMessage).append("], ").append(data)
				.toString();
	}
}
