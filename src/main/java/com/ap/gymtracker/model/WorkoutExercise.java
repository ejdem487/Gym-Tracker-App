package com.ap.gymtracker.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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

    @Column()
    private Integer sets;

    @Column
    private Integer reps;

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
