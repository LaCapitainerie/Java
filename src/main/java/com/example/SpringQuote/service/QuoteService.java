package com.example.SpringQuote.service;

import com.example.SpringQuote.model.Quote;
import com.example.SpringQuote.repository.QuoteRepository;

import org.springframework.stereotype.Service;

@Service
public class QuoteService {

	private final QuoteRepository QuoteRepository;

	// Injection par constructeur
	public QuoteService(QuoteRepository QuoteRepository) {
		this.QuoteRepository = QuoteRepository;
	}

	public Quote getRandomQuote() {
		return QuoteRepository.findAll().get((int) (Math.random() * QuoteRepository.count()));
	}
}
