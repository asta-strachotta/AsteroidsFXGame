package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Scoring {

	private int totalScore = 0;

	public static void main(String[] args) {
		SpringApplication.run(Scoring.class, args);
	}

	@GetMapping("/score")
	public String getScore(@RequestParam(value = "scorePoint") int scorePoint){
		totalScore += scorePoint;
		return "Total score is " + totalScore;
	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}

}
