package com.quotegenerator.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quotegenerator.exception.QuoteGeneratorException;
import com.quotegenerator.service.QuoteGeneratorService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class QuoteController {

    

	@Autowired
	QuoteGeneratorService quoteGeneratorService;
	private Map<String,List<Long>> requestTracker=new ConcurrentHashMap<>();
	private static final long timeDuration=60*1000;
	public int requestLimit;
    private static final Logger log = LoggerFactory.getLogger(QuoteController.class);

	@GetMapping("/getquote/{requestLimit}")
	public ResponseEntity<String> getQuote(@PathVariable("requestLimit") int requestLimit,HttpServletRequest request) {
		this.requestLimit=requestLimit-1;
		System.out.println("Request limit is:"+requestLimit);
		String clientIP=request.getRemoteAddr();
		System.out.println(clientIP);
		long systemTime=System.currentTimeMillis();
		
		requestTracker.putIfAbsent(clientIP, new CopyOnWriteArrayList<>());
		List<Long> timestamps=requestTracker.get(clientIP);
		System.out.println(timestamps);
		
		synchronized (timestamps) {
		timestamps.removeIf(time->time < systemTime - timeDuration);
		}
		System.out.println("After removing timestamps"+timestamps);
		
		if(timestamps.size() > requestLimit) {
			 log.info("Request from IP: {} -> Response: 429 Too Many Requests", clientIP);
			 throw new QuoteGeneratorException("error Rate limit exceeded. Try again in X seconds.");
		}
		
		timestamps.add(systemTime);
		  log.info("Request from IP: {} -> Response: 200 OK", clientIP);
		return new ResponseEntity<String>( quoteGeneratorService.getQuote(),HttpStatus.OK);
	}
}
