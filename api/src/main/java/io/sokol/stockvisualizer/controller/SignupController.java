package io.sokol.stockvisualizer.controller;

import io.sokol.stockvisualizer.entity.User;
import io.sokol.stockvisualizer.exceptions.UserAlreadyExistsException;
import io.sokol.stockvisualizer.service.auth.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        return signupService.registerUser(user);
    }

}