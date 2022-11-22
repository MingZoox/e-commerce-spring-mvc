package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "member")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long memberId;
	private String memberLogin;
	private String memberPass;
	private String memberMail;
	private int memberStatus;
	private String ROLE;

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getMemberLogin() {
		return memberLogin;
	}

	public void setMemberLogin(String memberLogin) {
		this.memberLogin = memberLogin;
	}

	public String getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}

	public String getMemberMail() {
		return memberMail;
	}

	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}

	public int isMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(int memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getROLE() {
		return ROLE;
	}

	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}

}
