package com.allitsolltd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allitsolltd.model.User;

@RestController
@RequestMapping("/kafka")
public class UserResource {
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplateString;
	
	@Autowired
	private KafkaTemplate<String,User> kafkaTemplate2;
	
	private static final String TOPIC = "Kafka_Example";
	
	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message")final String message) {
		kafkaTemplateString.send(TOPIC,message);

		return "Messaged Succesfully";
		
	}
	
	
	@PostMapping("/publish")
	public String post(@RequestBody User user) {
		
		System.out.println("======Ok=====");
		System.out.println("Entered");
		
		kafkaTemplate2.send(TOPIC,user);

		
		return "Published Successfully";
	}
	

}
