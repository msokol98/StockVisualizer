package io.sokol.stockvisualizer.service.auth;

import io.sokol.stockvisualizer.entity.Portfolio;
import io.sokol.stockvisualizer.entity.User;
import io.sokol.stockvisualizer.exceptions.UserAlreadyExistsException;
import io.sokol.stockvisualizer.repository.PortfolioRepository;
import io.sokol.stockvisualizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("signupService")
public class SignupServiceImpl implements SignupService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PortfolioRepository portfolioRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public ResponseEntity<?> registerUser(User user) throws UserAlreadyExistsException {
        Optional<User> optUser = userRepo.findByEmail(user.getEmail());

        if(optUser.isPresent())
            throw new UserAlreadyExistsException();

        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);

        Portfolio portfolio = new Portfolio();
        portfolio.setUser(user);
        portfolioRepo.save(portfolio);

        return ResponseEntity.ok().build();
    }
}
