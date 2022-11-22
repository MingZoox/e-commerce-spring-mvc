package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.entity.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
    private MemberDAO memberDAO;

    public Member login(String uname, String passwd) {
        return memberDAO.login(uname, passwd);
    }

}
