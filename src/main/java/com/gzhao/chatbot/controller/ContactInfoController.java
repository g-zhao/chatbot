package com.gzhao.chatbot.controller;

import com.gzhao.chatbot.data.ContactInfoDAO;
import com.gzhao.chatbot.model.ContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactInfoController {

    @Autowired
    private ContactInfoDAO contactInfoDAO;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void userInfoRequest(@RequestBody ContactInfo userInfo) {
        contactInfoDAO.addContactInfo(userInfo);
    }
}
