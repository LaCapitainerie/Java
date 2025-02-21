package com.example.SpringQuote.service;

import com.example.SpringQuote.model.Message;
import com.example.SpringQuote.repository.MessageRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private final MessageRepository MessageRepository;

	// Injection par constructeur
	public MessageService(MessageRepository MessageRepository) {
		this.MessageRepository = MessageRepository;
	}

	public List<Message> getAllPreviousMessage() {
		return MessageRepository.findAll();
	}
	
	public List<Message> getAllPreviousMessageByUsername(String username) {
		return MessageRepository.findAll().stream().filter(m -> m.getUsername().trim().toLowerCase().equals(username)).toList();
	}

	public List<String> getAllUsers() {
		return MessageRepository.findAll().stream().map(Message::getUsername).distinct().toList();
	}
	
	public void saveMessage(Message message) {
		MessageRepository.save(message);
	}

}
