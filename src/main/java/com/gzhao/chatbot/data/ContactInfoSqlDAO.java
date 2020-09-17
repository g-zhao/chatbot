package com.gzhao.chatbot.data;

import com.gzhao.chatbot.model.ContactInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContactInfoSqlDAO implements ContactInfoDAO {

    private JdbcTemplate jdbcTemplate;

    public ContactInfoSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addContactInfo(ContactInfo userInfo) {
        jdbcTemplate.update(
                "INSERT INTO contact_info (name, phone, email) VALUES (?, ?, ?)",
                userInfo.getName(), userInfo.getPhone(), userInfo.getEmail());
    }
}
