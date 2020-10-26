package io.sokol.stockvisualizer.service.auth;

import io.sokol.stockvisualizer.pojo.AuthRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> authenticate(AuthRequest request);
}
