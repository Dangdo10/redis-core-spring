package com.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisApplication {

//	@Bean
//	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
//		RedisTemplate<?, ?> template = new RedisTemplate<>();
//		template.setConnectionFactory(connectionFactory);
//
//		return template;
//	}

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}
