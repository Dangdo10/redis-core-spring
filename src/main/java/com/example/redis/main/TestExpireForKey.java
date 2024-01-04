package com.example.redis.main;

import redis.clients.jedis.Jedis;

public class TestExpireForKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);
        String key = "mykey";
        int expireTimeInSeconds = 30; // 30s

        // Đặt thời gian sống cho khóa
        jedis.expire(key, expireTimeInSeconds);

        // Đóng kết nối khi đã sử dụng xong
        jedis.close();
    }
}
