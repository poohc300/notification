package com.douzone.notification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.notification.repository.ChatRoomRepository;
import com.douzone.notification.service.ChatService;

@Controller
@RequestMapping("/chat")
public class ChatRoomController {

	private final ChatService chatService;
	
	@GetMapping(value="/room")
	public List<ChatRoom> room(){
		return chatService.findAllRoom();
	}
	
}
