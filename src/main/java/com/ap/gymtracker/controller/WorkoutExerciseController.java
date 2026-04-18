package com.ap.gymtracker.controller;

import com.ap.gymtracker.model.WorkoutExercise;
import com.ap.gymtracker.service.WorkoutExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ap.gymtracker.dto.WorkoutExerciseRequest;

import java.util.List;

@RestController
@RequestMapping("/api/workout-exercises")
@RequiredArgsConstructor
public class WorkoutExerciseController {
    private final WorkoutExerciseService workoutExerciseService;

    @GetMapping("/workout/{workoutId}")
    public List<WorkoutExercise> getByWorkoutId(@PathVariable Long workoutId) {
        return workoutExerciseService.findByWorkoutId(workoutId);
    }

    @GetMapping("/{id}")
    public WorkoutExercise getById(@PathVariable Long id) {
        return workoutExerciseService.getWorkoutExerciseById(id);
    }

    @PostMapping
    public WorkoutExercise addExerciseToWorkout(@Valid @RequestBody WorkoutExerciseRequest request){
    return workoutExerciseService.addExerciseToWorkout(
            request.getWorkoutId(),
            request.getExerciseId(),
            request.getSets(),
            request.getReps(),
            request.getWeight()

    );
    }

    @PutMapping("/{id}")
    public WorkoutExercise updateExerciseToWorkout(@PathVariable Long id,@Valid @RequestBody WorkoutExercise workoutExercise) {
        return workoutExerciseService.updateWorkoutExercise(id,workoutExercise);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        workoutExerciseService.removeExerciseFromWorkout(id);
    }
}
