package com.ap.gymtracker.controller;
import com.ap.gymtracker.service.WorkoutService;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.ap.gymtracker.model.Workout;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutService workoutService;

    @GetMapping
    public List<Workout> getAll(){
        return workoutService.getAllWorkouts();
    }

    @PostMapping
    public Workout createWorkout(@Valid @RequestBody Workout workout){
        return workoutService.createWorkout(workout);
    }

    @GetMapping("/{id}")
    public Workout getById(@PathVariable Long id){
        return workoutService.getWorkoutById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        workoutService.deleteWorkoutById(id);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id,@Valid @RequestBody Workout workout){
        return workoutService.updateWorkout(id, workout);
    }
}
