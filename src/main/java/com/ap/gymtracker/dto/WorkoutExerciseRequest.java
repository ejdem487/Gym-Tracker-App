package com.ap.gymtracker.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record WorkoutExerciseRequest (

    @NotNull(message = "Workout Id cannot be null")
     Long workoutId,

    @NotNull(message = "Exercise Id cannot be null")
     Long exerciseId,

    @Min(value = 1, message = "Sets must be at least 1")
     Integer sets,

    @Min(value = 1,message = "Reps must be at least 1")
     Integer reps,

    @Min(value = 0, message = "Weight cannot be negative")
     Integer weight
){}
