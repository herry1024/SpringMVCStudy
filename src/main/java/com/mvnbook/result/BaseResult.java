package com.mvnbook.result;

public class BaseResult {

	/**
	 * 必选，返回码
	 */
	private int code = 200;

	/**
	 * 可选，返回消息，网页端接口出现错误时使用此消息展示给用户，手机端可忽略此消息，甚至服务端不传输此消息。
	 */
	private String message = "";

	/**
	 * 必选，返回结果
	 */
	private Object value = null;

	/**
	 * 可选，当returnCode=302 重定向时，使用此URL重新请求
	 */
	private String redirect; //

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
}
