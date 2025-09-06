package com.quotegenerator.configuration;

import java.util.Random;
import java.util.random.RandomGenerator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
@Configuration
public class QuoteGeneratorConfiguration {

	@Bean
	public RandomGenerator getObjectForRandomGeneatorInterface() {
		Random random=new Random();
		return random;
	}
}
