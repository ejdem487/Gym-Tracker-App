package com.ap.gymtracker.controller;

import com.ap.gymtracker.model.Exercise;
import com.ap.gymtracker.service.ExerciseService;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    public List<Exercise> getAllExercises(){
        return exerciseService.getAllExercises();
    }

    @GetMapping("/{id}")
    public Exercise getExerciseById(@PathVariable Long id){
        return exerciseService.getExerciseById(id);
    }

    @PostMapping
    public Exercise createExercise(@Valid @RequestBody Exercise exercise){
        return exerciseService.createExercise(exercise);
    }

    @PutMapping("/{id}")
    public Exercise updateExercise(@PathVariable Long id,@Valid @RequestBody Exercise exercise){
        return exerciseService.updateExercise(id, exercise);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable Long id){
        exerciseService.deleteExerciseById(id);
    }
}
