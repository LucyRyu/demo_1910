package com.lucy.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucy.demo.dao.MemberDAO;

@Service
public class MemberService {

    @Autowired
    MemberDAO memberDAO;
    
    public String getUserInfo(String name) {
        return memberDAO.getUserInfo(name);
    }

}
