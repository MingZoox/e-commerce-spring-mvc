package com.service;

import com.entity.Member;

public interface MemberService {

    // login
    public Member login(String uname, String passwd);

}
