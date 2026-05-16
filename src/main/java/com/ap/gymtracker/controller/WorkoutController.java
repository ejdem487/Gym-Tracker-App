package com.ap.gymtracker.controller;
import com.ap.gymtracker.model.User;
import com.ap.gymtracker.service.WorkoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.ap.gymtracker.model.Workout;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutService workoutService;

    @GetMapping
    public List<Workout> getAll(@AuthenticationPrincipal User user){
        return workoutService.getAllWorkouts(user);
    }

    @PostMapping
    public Workout createWorkout(@Valid @RequestBody Workout workout, @AuthenticationPrincipal User user){
        return workoutService.createWorkout(workout, user);
    }

    @GetMapping("/{id}")
    public Workout getById(@PathVariable Long id, @AuthenticationPrincipal User user){
        return workoutService.getWorkoutById(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @AuthenticationPrincipal User user){
        workoutService.deleteWorkoutById(id,  user);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id,@Valid @RequestBody Workout workout, @AuthenticationPrincipal User user){
        return workoutService.updateWorkout(id, workout, user);
    }
}
