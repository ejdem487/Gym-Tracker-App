package com.ap.gymtracker.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "workout_exercises")
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Sets cannot be null")
    @Min(value = 1, message = "Sets must be at least 1")
    @Column
    private Integer sets;

    @Min(value = 1, message = "Reps must be at least 1")
    @Column
    private Integer reps;

    @Min(value = 0, message = "Weight cannot be negative")
    @Column
    private Integer weight;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "workout_id",nullable = false)
    @JsonBackReference("workout-workoutExercise")
    private Workout workout;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "exercise_id",nullable = false)
    @JsonBackReference("exercise-workoutExercise")
    private Exercise exercise;
}
