package com.rafarodrigues.hruser.resources;

import com.rafarodrigues.hruser.entities.User;
import com.rafarodrigues.hruser.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findbyId(@PathVariable Long id) throws NotFoundException {
        User user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("user not found"));
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) throws NotFoundException {
        User user = repository.findByEmail(email).orElseThrow(() -> new NotFoundException("user not found"));
        return ResponseEntity.ok(user);
    }
}