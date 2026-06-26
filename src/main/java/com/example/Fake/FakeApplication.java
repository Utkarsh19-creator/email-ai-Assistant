package com.example.Fake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(excludeName ={
		"org.springframework.ai.model.google.genai.autoconfigure.chat.GoogleGenAiChatAutoConfiguration"
})
public class FakeApplication{

	public static void main(String[] args) {
		SpringApplication.run(FakeApplication.class, args);
	}

}
