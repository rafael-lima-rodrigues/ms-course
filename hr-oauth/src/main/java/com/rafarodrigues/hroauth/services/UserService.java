package com.rafarodrigues.hroauth.services;

import com.rafarodrigues.hroauth.entities.User;
import com.rafarodrigues.hroauth.feignclients.UserFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClients userFeignClients;

    public User findByEmail(String email) {
        User user = Optional.ofNullable(userFeignClients.findByEmail(email).getBody())
                .orElseThrow(() -> new IllegalArgumentException("Email not found"));
        logger.info("Email found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userFeignClients.findByEmail(username).getBody())
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        logger.info("Email found: " + username);
        return user;
    }
}
