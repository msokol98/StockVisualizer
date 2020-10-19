package io.sokol.stockvisualizer.service.auth;

import io.sokol.stockvisualizer.entity.User;
import io.sokol.stockvisualizer.exceptions.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;

public interface SignupService {
    ResponseEntity<?> registerUser(User u) throws UserAlreadyExistsException;
}
