package com.example.mady.api;

import com.example.mady.dto.request.AuthRequest;
import com.example.mady.dto.response.AuthResponse;
import com.example.mady.model.enums.Role;
import com.example.mady.service.AuthService;
import io.swagger.v3.oas.annotations.OpenAPI30;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthApi {
    private final AuthService authService;

    @PostMapping("save")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Operation(summary = "Only administrator can add users")
    public AuthResponse save(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam Role role) {
        return authService.save(name, email, password, role);
    }

    @PostMapping("login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}