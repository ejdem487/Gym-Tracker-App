package com.ap.gymtracker.controller;

import com.ap.gymtracker.model.User;
import com.ap.gymtracker.model.WorkoutExercise;
import com.ap.gymtracker.service.WorkoutExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.ap.gymtracker.dto.WorkoutExerciseRequest;

import java.util.List;

@RestController
@RequestMapping("/api/workout-exercises")
@RequiredArgsConstructor
public class WorkoutExerciseController {
    private final WorkoutExerciseService workoutExerciseService;

    @GetMapping("/workout/{workoutId}")
    public List<WorkoutExercise> getByWorkoutId(@PathVariable Long workoutId, @AuthenticationPrincipal User user) {
        return workoutExerciseService.findByWorkoutId(workoutId, user);
    }

    @GetMapping("/{id}")
    public WorkoutExercise getById(@PathVariable Long id, @AuthenticationPrincipal User user) {
        return workoutExerciseService.getWorkoutExerciseById(id,  user);
    }

    @PostMapping 
    public WorkoutExercise addExerciseToWorkout(@Valid @RequestBody WorkoutExerciseRequest request,  @AuthenticationPrincipal User user) {
    return workoutExerciseService.addExerciseToWorkout(
            request.workoutId(),
            user,
            request.exerciseId(),
            request.sets(),
            request.reps(),
            request.weight()

    );
    }

    @PutMapping("/{id}")
    public WorkoutExercise updateExerciseToWorkout(@PathVariable Long id,@AuthenticationPrincipal User user,@Valid @RequestBody WorkoutExercise workoutExercise) {
        return workoutExerciseService.updateWorkoutExercise(id,user,workoutExercise);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @AuthenticationPrincipal User user) {
        workoutExerciseService.removeExerciseFromWorkout(id,  user);
    }
}
