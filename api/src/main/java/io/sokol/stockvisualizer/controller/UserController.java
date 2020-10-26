package io.sokol.stockvisualizer.controller;

import io.sokol.stockvisualizer.dto.UserDTO;
import io.sokol.stockvisualizer.exceptions.UserDoesNotExistException;
import io.sokol.stockvisualizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    private UserDTO getUserByEmail(@RequestParam("email") String email) throws UserDoesNotExistException {
        return userService.getUserByEmail(email);
    }

}
