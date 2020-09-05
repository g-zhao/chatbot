package com.gzhao.chatbot.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ContactInfo {
	
	@NotBlank (message = "Name cannot be blank")
	private String name = "";
	
	@Email (message = "Email address does not meet valid email requirements")
	private String email ="";
	
	@Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}", message = "Phone number formatting is incorrect.")
	private String phone ="";
	
	public void contactInfo(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	
	
}
