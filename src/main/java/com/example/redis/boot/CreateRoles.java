package com.example.redis.boot;

import com.example.redis.model.Role;
import com.example.redis.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class CreateRoles implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role adminRole = Role.builder()
                    .name("admin")
                    .build();
            Role customerRole = Role.builder()
                    .name("customer")
                    .build();
            roleRepository.save(adminRole);
            roleRepository.save(customerRole);
            log.info(">>> Created admin and customer roles ...");
        }
//        System.out.println(">>> Hello from createRoles CommandlineRunner ...");
    }
}
