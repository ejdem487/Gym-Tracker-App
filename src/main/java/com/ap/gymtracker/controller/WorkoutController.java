package com.ap.gymtracker.controller;
import com.ap.gymtracker.model.Workout;
import com.ap.gymtracker.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public Workout createWorkout(@RequestBody Workout workout){
        return workoutService.createWorkout(workout);
    }

    @GetMapping("/{id}")
    public Workout getById(@PathVariable long id){
        return workoutService.getWorkoutById(id);
    }
}
