package com.example.demo.member.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRole {

	private String rolename;
	
	public MemberRole(String rolename) {
		this.rolename = rolename;
	}
}
