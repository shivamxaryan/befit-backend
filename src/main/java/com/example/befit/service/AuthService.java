package com.example.befit.service;

import com.example.befit.dto.request.RegistrationRequest;
import com.example.befit.dto.response.ApiResponse;
import com.example.befit.entity.User;
import com.example.befit.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;

    @Transactional
    public ApiResponse<Void> register(@Valid RegistrationRequest request){
        try{
            User user = new User();
            user.setFullName(request.getFullName());
            user.setEmail(request.getEmail());
            user.setDob(request.getDob());
            user.setGender(request.getGender());
            user.setPasswordHash(request.getPassword());
            userRepository.save(user);

            return ApiResponse.<Void>builder()
                    .success(true)
                    .message("User registered successfully")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
