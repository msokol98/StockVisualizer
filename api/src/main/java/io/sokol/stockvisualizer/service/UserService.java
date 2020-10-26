package io.sokol.stockvisualizer.service;

import io.sokol.stockvisualizer.dto.UserDTO;
import io.sokol.stockvisualizer.exceptions.UserDoesNotExistException;

public interface UserService {
    UserDTO getUserByEmail(String email) throws UserDoesNotExistException;
}
