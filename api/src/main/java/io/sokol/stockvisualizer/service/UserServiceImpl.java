package io.sokol.stockvisualizer.service;

import io.sokol.stockvisualizer.dto.UserDTO;
import io.sokol.stockvisualizer.entity.User;
import io.sokol.stockvisualizer.exceptions.UserDoesNotExistException;
import io.sokol.stockvisualizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDTO getUserByEmail(String email) throws UserDoesNotExistException {
        Optional<User> optUser = userRepo.findByEmail(email);
        optUser.orElseThrow(UserDoesNotExistException::new);
        return new UserDTO(optUser.get());
    }
}
