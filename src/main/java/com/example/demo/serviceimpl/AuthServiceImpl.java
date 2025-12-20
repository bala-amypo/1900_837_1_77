package com.example.demo.serviceimpl;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(String email, String password, String role) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        // ✅ FIX: String → Role
        user.setRole(Role.valueOf(role.toUpperCase()));

        return userRepository.save(user);
    }

    @Override
    public String login(User user) {
        // ✅ FIX: Role → String
        return user.getRole().name();
    }
}
