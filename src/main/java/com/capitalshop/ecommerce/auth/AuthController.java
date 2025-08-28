package com.capitalshop.ecommerce.auth;

import com.capitalshop.ecommerce.user.model.entities.UserAccount;
import com.capitalshop.ecommerce.user.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;
import com.capitalshop.ecommerce.auth.dto.LoginRequest;
import com.capitalshop.ecommerce.auth.JwtUtil;
import com.capitalshop.ecommerce.common.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.capitalshop.ecommerce.auth.dto.RegisterRequest;
import com.capitalshop.ecommerce.user.model.enums.UserType;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        UserAccount user = UserAccount.builder().build();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhone_number(userRequest.getPhoneNumber());
        user.setName(userRequest.getFullName());
        user.setUserType(userRequest.getUserType() != null ? userRequest.getUserType() : UserType.CUSTOMER); // Default to CUSTOMER if not specified
        // Check if user already exists
        if (userAccountRepository.existsByEmail(user.getEmail())) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, "User already exists", null);
        }

        UserAccount savedUser = userAccountRepository.save(user);
        return ResponseHandler.generateResponse(HttpStatus.CREATED, "User registered successfully", savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest user) {
        try {
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
            UserAccount foundUser = userAccountRepository.findByEmail(user.getEmail()).orElse(null);
            String token = jwtUtil.generateToken(user.getEmail());
            Map<String, Object> responseMap = Map.of("token", token, "user", foundUser);

            return ResponseHandler.generateResponse(HttpStatus.OK, "Login successful", responseMap);
        } catch (AuthenticationException e) {
            return ResponseHandler.generateResponse(HttpStatus.UNAUTHORIZED, "Invalid credentials", null);
        }
    }
}
