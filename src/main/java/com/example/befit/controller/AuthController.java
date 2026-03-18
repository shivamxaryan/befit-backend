package com.example.befit.controller;

import com.example.befit.dto.request.LoginRequest;
import com.example.befit.dto.request.RegistrationRequest;
import com.example.befit.dto.response.ApiResponse;
import com.example.befit.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest){
        try {
            ApiResponse response = authService.register(registrationRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error during user registration", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error registering user: " + e.getMessage(), null));
        }
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<ApiResponse<String>> login(@Valid @RequestBody LoginRequest request) {

        String token = authService.login(request);

        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(true)
                .message("Login successful")
                .data(token)
                .build();

        return ResponseEntity.ok(response);
    }
}
