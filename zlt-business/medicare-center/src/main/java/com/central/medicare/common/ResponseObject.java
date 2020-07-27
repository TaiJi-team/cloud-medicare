package com.central.medicare.common;

import java.io.Serializable;

/**
 * @author yuan.zk
 */
public class ResponseObject implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 业务异常
	 */
	public static final Integer STATUS_400 = 400;
	/**
	 * 业务错误-未登录
	 */
	public static final Integer STATUS_511 = 511;
	/**
	 * 业务错误-校验失败
	 */
	public static final Integer STATUS_512 = 512;
	/**
	 * 业务错误-手机短信验证码发送失败
	 */
	public static final Integer STATUS_513 = 513;
	/**
	 * 正常请求
	 */
	public static final Integer STATUS_200 = 200;
	/**
	 * 业务错误-其他
	 */
	public static final Integer STATUS_514 = 514;
	/**
	 * 系统未知异常
	 */
	public static final Integer STATUS_500 = 500;

	/**
	 * 请求成功
	 */
	private Integer status = STATUS_200;

	private String errorMessage;

	private Object resultObject;

	public static ResponseObject newErrorResponseObject(final Integer status, final String errorMessage) {
		final ResponseObject res = new ResponseObject();
		res.setStatus(status);
		res.setErrorMessage(errorMessage);
		return res;
	}

	public static ResponseObject newSuccessResponseObject(final Object resultObject) {
		final ResponseObject res = new ResponseObject();
		res.setResultObject(resultObject);
		return res;
	}

	public static ResponseObject newSuccessResponseObject(final Object resultObject, final String message) {
		final ResponseObject res = new ResponseObject();
		res.setResultObject(resultObject);
		res.setErrorMessage(message);
		return res;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(final Object resultObject) {
		this.resultObject = resultObject;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(final Integer status) {
		this.status = status;
	}

}
