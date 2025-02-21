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

	public void saveMessage(Message message) {
		MessageRepository.save(message);
	}

}
