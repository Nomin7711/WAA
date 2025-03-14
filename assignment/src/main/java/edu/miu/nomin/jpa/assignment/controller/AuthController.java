package edu.miu.nomin.jpa.assignment.controller;

import edu.miu.nomin.jpa.assignment.entity.User;
import edu.miu.nomin.jpa.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping
    public boolean authenticate() {
        return true;
    }
    @PostMapping
    public User authenticate(@RequestBody User user) {
        return userService.findByName(user.getName());
    }
}
