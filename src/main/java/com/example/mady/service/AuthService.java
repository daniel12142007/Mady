package com.example.mady.service;

import com.example.mady.config.JwtUtils;
import com.example.mady.dto.request.AuthRequest;
import com.example.mady.dto.response.AuthResponse;
import com.example.mady.model.User;
import com.example.mady.model.enums.Role;
import com.example.mady.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse save(String name,
                             String email,
                             String password,
                             Role role) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(password));
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("user exists email");
        }
        return map(userRepository.save(user));
    }

    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).get();
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("invalid password");
        }
        return map(user);
    }

    private AuthResponse map(User user) {
        return new AuthResponse(
                user.getId(),
                user.getEmail(),
                jwtUtils.generateToken(user.getEmail()),
                user.getRole()
        );
    }
}