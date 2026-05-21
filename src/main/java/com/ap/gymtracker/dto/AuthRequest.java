package com.ap.gymtracker.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AuthRequest (

        @NotBlank(message = "Username cannot be blank")
        String username,

        @NotBlank(message = "Password cannot be empty")
        @Size(min = 8)
        String password
){}
