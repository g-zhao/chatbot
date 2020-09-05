package com.gzhao.chatbot.data;

import com.gzhao.chatbot.model.Response;

public interface ResponseDAO {

	Response questionResponse(String responseTopic);
	
}
