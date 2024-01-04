package com.example.redis.controller;

import com.example.redis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/redis")
public class DevelopController {

    @Autowired
    private RedisTemplate<String, String> template;

    private static final String STRING_KEY_PREFIX = "redis:strings:";
    private static final String STRING_BEARS = "bears:";
    private static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYW5nZG8xMTk4IiwiaWF0IjoxNzA0Mjk4NTQzLCJleHAiOjE3MDQzODQ5NDN9.a8ZwMFA1ftFkk2sJ7AM6hIp8Frturi_IBvXIZkxx9Mk5blr5UG3G-6pFslaHjPMyRZf0MQvqEOwlTsbB-l6Hfw";


    @PostMapping("/strings")
    @ResponseStatus(HttpStatus.CREATED)
    public Map.Entry<String, String> setString(@RequestBody Map.Entry<String, String> kvp) {
//        template.opsForValue().set(STRING_KEY_PREFIX + kvp.getKey(), kvp.getValue());
        template.opsForValue().set(STRING_BEARS + "dangdo", "token12345");
        return kvp;
    }

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    public String setString(@RequestBody Student student) {
        template.opsForValue().set(STRING_BEARS + student.getName(), TOKEN);

        // Đặt thời gian sống cho khóa (10 giây)
        template.expire(STRING_BEARS + student.getName(), 60, TimeUnit.SECONDS);
        return student.getName();
    }

    @GetMapping("/strings/{key}")
    public Map.Entry<String, String> getMapString(@PathVariable("key") String key) {
        String value = template.opsForValue().get(STRING_KEY_PREFIX + key);

        if (value == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "key not found");
        }

        return new AbstractMap.SimpleEntry<String, String>(key, value);
    }


    @GetMapping("/string/{key}")
    public String getString(@PathVariable("key") String key) {
        String value = template.opsForValue().get(STRING_BEARS + key);

        if (value == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "key not found");
        }

        return value;
    }



}
