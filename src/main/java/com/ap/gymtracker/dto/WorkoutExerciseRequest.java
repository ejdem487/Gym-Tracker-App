package com.ap.gymtracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class WorkoutExerciseRequest {
    private Long workoutId;
    private Long exerciseId;
    private Integer sets;
    private Integer reps;
    private Integer weight;
}
