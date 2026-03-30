package com.ap.gymtracker.Service;

import com.ap.gymtracker.dto.AuthRequest;
import com.ap.gymtracker.dto.AuthResponse;
import com.ap.gymtracker.repository.UserRepository;
import com.ap.gymtracker.security.JwtService;
import com.ap.gymtracker.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    JwtService jwtService;

    @Mock
    AuthenticationManager authenticationManager;

    @InjectMocks
    AuthService authService;

    @Test

    void registerShouldReturnToken() {
        AuthRequest request = new AuthRequest();
        request.setUsername("admin");
        request.setPassword("5678");

        when(userRepository.findByUsername(request.getUsername())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(request.getPassword())).thenReturn("encoded5678");
        when(jwtService.generateToken("admin")).thenReturn("token456");

        AuthResponse response = authService.register(request);

        assertEquals("token456", response.getToken());
    }
}
