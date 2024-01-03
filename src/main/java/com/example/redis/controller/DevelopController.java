package com.example.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.AbstractMap;
import java.util.Map;

@RestController
@RequestMapping("/api/redis")
public class DevelopController {

    @Autowired
    private RedisTemplate<String, String> template;

    private static final String STRING_KEY_PREFIX = "redis:strings:";
    private static final String STRING_BEARS = "bears:";


    @PostMapping("/strings")
    @ResponseStatus(HttpStatus.CREATED)
    public Map.Entry<String, String> setString(@RequestBody Map.Entry<String, String> kvp) {
        template.opsForValue().set(STRING_KEY_PREFIX + kvp.getKey(), kvp.getValue());
        template.opsForValue().set(STRING_BEARS + "dangdo", "token1234");
        return kvp;
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
