package com.gzhao.chatbot.model;

public class Response {

	private String responseStr;
	
	public void response(String question) {
		this.responseStr = question;
	}

	public String getResponseStr() {
		return responseStr;
	}

	public void setResponseStr(String responseStr) {
		this.responseStr = responseStr;
	}

}