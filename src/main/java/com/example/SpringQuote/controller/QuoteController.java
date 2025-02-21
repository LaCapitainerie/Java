package com.example.SpringQuote.controller;

import com.example.SpringQuote.model.Quote;
import com.example.SpringQuote.service.QuoteService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getQuote")
public class QuoteController {

	private final QuoteService QuoteService;

	public QuoteController(QuoteService QuoteService) {
		this.QuoteService = QuoteService;
	}

	@GetMapping
	public String getRandomQuote() {
		Quote Quotes = QuoteService.getRandomQuote();
		return Quotes.getText();
	}
}
