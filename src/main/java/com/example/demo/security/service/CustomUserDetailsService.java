package com.example.demo.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.member.model.Member;
import com.example.demo.member.model.MemberRole;
import com.example.demo.member.model.SecurityMember;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		
		List<Integer> channel= new ArrayList<>();
		List<MemberRole> roles = new ArrayList<>();
		
		channel.add(1);
		channel.add(2);
		channel.add(3);
		
		roles.add(new MemberRole("USER"));
		
		
		List<Member> memberList = new ArrayList<>();
		memberList.add(new Member(1,"test1",passwordEncoder.encode("test"),channel,roles));
		memberList.add(new Member(2,"test2",passwordEncoder.encode("test"),channel,roles));
		memberList.add(new Member(3,"test3",passwordEncoder.encode("test"),channel,roles));
		//new ArrayList<MemberRole>().add(new MemberRole("ADMIN"));
		
		SecurityMember securityMember=null;
		
		for(int i=0; i<memberList.size(); i++) {
			if(userid.equals(memberList.get(i).getUserid())) {
				securityMember = new SecurityMember(memberList.get(i));
				securityMember.setChannel(memberList.get(i).getChannel());
				securityMember.setUno(memberList.get(i).getUno());
			}
		}
		
		
		return securityMember;
	}

	
}
