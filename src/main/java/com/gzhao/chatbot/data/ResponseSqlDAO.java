package com.gzhao.chatbot.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.gzhao.chatbot.model.Response;

@Component
public class ResponseSqlDAO implements ResponseDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ResponseSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public Response questionResponse(String responseTopic) {
		Response thisResponse = new Response();
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(
				"SELECT response FROM responses WHERE topic = ?", responseTopic);
		
		if (result.next()) {
			thisResponse.setResponseStr(result.getString("response"));
		}
		return thisResponse;
	}

}
