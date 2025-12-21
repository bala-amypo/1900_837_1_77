package com.example.demo.serviceimpl;

import com.example.demo.config.JwtUtil;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String register(String username, String password) {

        User user = new User();
        user.setUsername(username);          
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.STUDENT);          

        userRepository.save(user);

        // generateToken(username, role)
        return jwtUtil.generateToken(user.getUsername(), user.getRole().name());
    }
}
