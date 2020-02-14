package com.example.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.chat.model.ChatMessage;

@Controller
public class testController {
	
	@Autowired
	SimpMessageSendingOperations messagingTemplate;
	
	
	

	@RequestMapping("/")
	public String test(Model model) {
		
		//map은 해당 사용자의 정보를 담을 VO(DTO) 역할
		Map<String,Object> map = new HashMap<>();
		
		//list는 해당 사용자가 가입한 채널(채팅방)의 목록
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		map.put("list", list);
		map.put("userId","userid");
		model.addAttribute("map",map);
		return "index2";
	}
	
	@MessageMapping("/chat/message")
	public void message(ChatMessage message) {
		//구독한 곳에 전달한다.
		//주어진 목적지 이름을 목적지로 MessageConverter해석하고 , 페이로드 오브젝트를 직렬화 된 양식으로 변환하고, 가능하면을 사용하여 이를 메시지로 랩핑하여 해석 된 목적지로 전송하십시오.
		messagingTemplate.convertAndSend("/sub/chat/room/"+message.getRoomId(),message );
		
		
	}
	
}
	
	
	

