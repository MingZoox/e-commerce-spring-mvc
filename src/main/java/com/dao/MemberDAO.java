package com.dao;

import com.entity.Member;

public interface MemberDAO {

    public Member login(String uname, String passwd);

}