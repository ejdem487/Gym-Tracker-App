package com.ap.gymtracker.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Column(nullable = false,unique = true)
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "exercise",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("exercise-workoutExercise")
    private List<WorkoutExercise> workoutExercises = new ArrayList<>();

}
