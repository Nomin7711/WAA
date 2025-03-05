package edu.miu.nomin.jpa.assignment.controller;

import edu.miu.nomin.jpa.assignment.entity.Role;
import edu.miu.nomin.jpa.assignment.entity.User;
import edu.miu.nomin.jpa.assignment.entity.dto.request.LoginRequest;
import edu.miu.nomin.jpa.assignment.entity.dto.response.LoginResponse;
import edu.miu.nomin.jpa.assignment.service.AuthService;
import edu.miu.nomin.jpa.assignment.service.RoleService;
import edu.miu.nomin.jpa.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    private final AuthService authService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(
                loginResponse, HttpStatus.OK);
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                Role existingRole = roleService.findByRole(role.getRole());
                if (existingRole == null) {
                    roleService.save(role);
                }
            }
        }
        return userService.save(user);
    }
    @PostMapping("/register/role")
    public Role registerRole(@RequestBody Role role) {
        return roleService.save(role);
    }

}
