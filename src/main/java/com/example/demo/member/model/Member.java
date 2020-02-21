package com.example.demo.member.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	private int uno;
	private String userid;
	private String password;
	//원래 이렇게 다 들고 다니나....session에...
	private List<Integer> channel;
	private List<MemberRole> roles;
	
	public Member(int uno,String userid,String password,List<Integer> channel, List<MemberRole> roles) {
			this.uno = uno;
			this.userid = userid;
			this.password = password;
			this.channel = channel;
			this.roles = roles;
	}
}
