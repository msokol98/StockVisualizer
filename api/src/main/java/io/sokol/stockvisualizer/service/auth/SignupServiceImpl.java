package io.sokol.stockvisualizer.service.auth;

import io.sokol.stockvisualizer.entity.User;
import io.sokol.stockvisualizer.exceptions.UserAlreadyExistsException;
import io.sokol.stockvisualizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("signupService")
public class SignupServiceImpl implements SignupService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public ResponseEntity<?> registerUser(User user) throws UserAlreadyExistsException {
        Optional<User> optUser = userRepo.findByEmail(user.getEmail());

        if(optUser.isPresent())
            throw new UserAlreadyExistsException();

        userRepo.save(user);
        return ResponseEntity.ok().build();
    }
}
