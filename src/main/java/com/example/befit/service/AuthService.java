package com.example.befit.service;

import com.example.befit.dto.request.LoginRequest;
import com.example.befit.dto.request.RegistrationRequest;
import com.example.befit.dto.response.ApiResponse;
import com.example.befit.entity.Users;
import com.example.befit.repository.UserRepository;
import com.example.befit.security.JwtUtil;
import io.jsonwebtoken.Jwts;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Transactional
    public ApiResponse<Void> register(@Valid RegistrationRequest request){
        try{
            Users user = new Users();
            user.setFullName(request.getFullName());
            user.setEmail(request.getEmail());
            user.setDob(request.getDob());
            user.setGender(request.getGender());
            user.setPassword(encoder.encode(request.getPassword()));
            userRepository.save(user);

            return ApiResponse.<Void>builder()
                    .success(true)
                    .message("User registered successfully")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String login(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        return jwtUtil.generateToken(request.getEmail());
    }
}
