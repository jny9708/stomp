package com.example.demo.member.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SecurityMember extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String ROLE_PREFIX = "ROLE_";
	
	private int uno;
	private List<Integer> channel;
	
	
	public SecurityMember(Member member) {
		super(member.getUserid(), member.getPassword(), makeGrantedAuthority(member.getRoles()));
		// TODO Auto-generated constructor stub
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
		List<GrantedAuthority> list = new ArrayList<>();
		
		for(int i=0; i<roles.size(); i++) {
			list.add(new SimpleGrantedAuthority(ROLE_PREFIX + roles.get(i).getRolename()));
		}
		
		return list;
	}
	
}
