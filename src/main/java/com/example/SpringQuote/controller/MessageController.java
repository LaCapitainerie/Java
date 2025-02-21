package com.example.SpringQuote.controller;

import com.example.SpringQuote.model.Message;
import com.example.SpringQuote.model.Quote;
import com.example.SpringQuote.service.MessageService;
import com.example.SpringQuote.service.QuoteService;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class MessageController {

	private final MessageService MessageService;
	private final QuoteService QuoteService;

	public MessageController(MessageService MessageService, QuoteService QuoteService) {
		this.MessageService = MessageService;
		this.QuoteService = QuoteService;
	}

	@GetMapping
	public String getRandomMessage(Model model) {
		model.addAttribute("messages", MessageService.getAllPreviousMessage());
		model.addAttribute("users", MessageService.getAllUsers());
		return "chat";
	}

	@GetMapping("/{users}")
	public String getMessages(@PathVariable String users, Model model) {
		model.addAttribute("messages", MessageService.getAllPreviousMessageByUsername(users));
		model.addAttribute("users", MessageService.getAllUsers());
		return "chat";
	}

	@PostMapping
	public String postMessage(@RequestParam("message") String message, @RequestParam("username") String username, Model model) {
		Message m = new Message();
		Quote quote = QuoteService.getRandomQuote();
		m.setText(message);
		m.setUsername(username);
		m.setQuote(quote.getText());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM YYYY à HH:mm");
		m.setUpdated_at(java.time.LocalDateTime.now().format(dtf));
		MessageService.saveMessage(m);
		model.addAttribute("messages", MessageService.getAllPreviousMessage());
		model.addAttribute("users", MessageService.getAllUsers());
		return "chat";
	}

}
