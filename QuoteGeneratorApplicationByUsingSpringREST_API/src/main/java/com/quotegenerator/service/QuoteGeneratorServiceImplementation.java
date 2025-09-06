package com.quotegenerator.service;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuoteGeneratorServiceImplementation implements QuoteGeneratorService{

	@Autowired
	RandomGenerator randomGenerator;

	@Override
	public String getQuote() {
		// TODO Auto-generated method stub
		ConcurrentHashMap<Integer, String> quoteList=new ConcurrentHashMap<Integer, String>();
		quoteList.put(1, "The only way to do great work is to love what you do. - Steve Jobs");
		quoteList.put(2, "Don’t watch the clock; do what it does. Keep going. – Sam Levenson");
		quoteList.put(3, "Success is not final, failure is not fatal: it is the courage to continue that counts. – Winston Churchill");
		quoteList.put(4, "Opportunities don't happen, you create them. – Chris Grosser");
		quoteList.put(5, "Your time is limited, so don’t waste it living someone else’s life. – Steve Jobs");
		
		int randomNumber=randomGenerator.nextInt(1, 5);
		System.out.println(randomNumber);
		return quoteList.get(randomNumber);
	}

}
