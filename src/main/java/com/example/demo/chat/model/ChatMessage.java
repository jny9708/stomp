package com.example.demo.chat.model;

import java.io.File;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
	private String roomId;
	private String sender;
	private String message;
	//private File file;
}
