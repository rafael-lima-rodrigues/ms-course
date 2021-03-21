package com.rafarodrigues.hroauth.services;

import com.rafarodrigues.hroauth.entities.User;
import com.rafarodrigues.hroauth.feignclients.UserFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClients userFeignClients;

    public User findByEmail(String email) {
        User user = Optional.ofNullable(userFeignClients.findByEmail(email).getBody())
                .orElseThrow(() -> new IllegalArgumentException("Email not found"));
        logger.info("Email found: " + email);
        return user;
    }
}
