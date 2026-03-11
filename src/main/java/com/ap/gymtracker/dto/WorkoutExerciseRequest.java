package com.ap.gymtracker.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class WorkoutExerciseRequest {

    @NotNull(message = "Workout Id cannot be null")
    private Long workoutId;

    @NotNull(message = "Exercise Id cannot be null")
    private Long exerciseId;

    @Min(value = 1, message = "Sets must be at least 1")
    private Integer sets;

    @Min(value = 1,message = "Reps must be at least 1")
    private Integer reps;

    @Min(value = 0, message = "Weight cannot be negative")
    private Integer weight;
}
