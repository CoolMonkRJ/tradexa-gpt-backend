package com.tradexa.gpt.service;

import com.tradexa.gpt.dto.RegisterRequest;
import com.tradexa.gpt.dto.RegisterResponse;
import com.tradexa.gpt.entity.User;
import com.tradexa.gpt.entity.UserRole;
import com.tradexa.gpt.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.tradexa.gpt.exception.UserAlreadyExistsException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(request.getEmail());
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(UserRole.USER);

        User savedUser = userRepository.save(user);

        RegisterResponse response = new RegisterResponse();

        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole().name());

        return response;
    }
}
