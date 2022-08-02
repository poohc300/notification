package com.douzone.notification.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.douzone.notification.vo.ChatRoom;

@Service
public class ChatService {

	private Map<String, ChatRoom> chatRooms;
	
	@PostConstruct
	private void init() {
		chatRooms = new LinkedHashMap<>();
	}
	
	// 채팅방 생성
	public ChatRoom createRoom(String name) {
		ChatRoom chatRoom = ChatRoom.createChatRoom(name);
		chatRooms.put(chatRoom.getRoomId(), chatRoom);
		return chatRoom;
	}
	
	// 채팅방 전체 불러오기
	public List<ChatRoom> findAllRoom(){
		List<ChatRoom> result = new ArrayList<>(chatRooms.values());
		Collections.reverse(result);
		
		return result;
	}
	
	// 채팅방 하나 검색
	public ChatRoom findById(String roomId) {
		return chatRooms.get(roomId);
	}
}
