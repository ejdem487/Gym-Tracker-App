package com.ap.gymtracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExerciseRequest(
        @NotBlank(message = "Name cannot be empty")
        String name,
        String description
) {
}
