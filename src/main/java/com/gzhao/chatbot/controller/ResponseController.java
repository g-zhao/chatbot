package com.gzhao.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzhao.chatbot.data.ResponseDAO;
import com.gzhao.chatbot.model.Question;
import com.gzhao.chatbot.model.Response;

@RestController
public class ResponseController {
	
	@Autowired
	private ResponseDAO responseDAO;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public Response questionIntake(@RequestParam Question question) {
		String questionStr = question.getQuestion();
		String responseTopic = "";

		if (questionStr.contains("graduation") && questionStr.contains("rate")) {
			responseTopic = "gradrate";
		} else if ((questionStr.contains("length") || questionStr.contains("long")) && (questionStr.contains("course")
				|| questionStr.contains("bootcamp") || questionStr.contains("program"))) {
			responseTopic = "lengthOfProgram";
		} else if (questionStr.contains("phone") || questionStr.contains("number")) {
			responseTopic = "phoneNumber";
		} else if (questionStr.contains("contact") || questionStr.contains("email")) {
			responseTopic = "email";
		} else if (questionStr.contains("live") && questionStr.contains("remote") || questionStr.contains("start")
				|| questionStr.contains("date") || questionStr.contains("cohort")) {
			responseTopic = "liveRemoteStart";
		} else if (questionStr.contains("locations") || questionStr.contains("location")) {
			responseTopic = "locations";
		} else if (questionStr.contains("programming") || questionStr.contains("languages")) {
			responseTopic = "progLanguages";
		} else if ((questionStr.contains("size") || questionStr.contains("sizes")) && questionStr.contains("student")
				|| questionStr.contains("class") || questionStr.contains("many")) {
			responseTopic = "classSize";
		} else if (questionStr.contains("need") && questionStr.contains("code") || questionStr.contains("coding")
				|| questionStr.contains("experience")) {
			responseTopic = "needCodeExp";
		} else if (questionStr.contains("cost") || questionStr.contains("tuition")) {
			responseTopic = "tuition";
		} else if (questionStr.contains("financing") || questionStr.contains("finance")) {
			responseTopic = "financing";
		} else if (questionStr.contains("next") && questionStr.contains("steps") || questionStr.contains("step")
				|| questionStr.contains("apititude")) {
			responseTopic = "nextSteps";
		} else if (questionStr.contains("apply")) {
			responseTopic = "apply";
		} else if (questionStr.equals("Q") || questionStr.equals("q")) {
			responseTopic = "quit";
		} else {
			responseTopic = "unableToHelp";
		}
		
		Response response = responseDAO.questionResponse(responseTopic);

		return response;
	}

}
