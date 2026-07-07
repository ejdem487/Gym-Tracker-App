package com.ap.gymtracker.controller;

import com.ap.gymtracker.dto.ExerciseRequest;
import com.ap.gymtracker.dto.ExerciseResponse;
import com.ap.gymtracker.model.Exercise;
import com.ap.gymtracker.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    public List<ExerciseResponse> getAllExercises(){
        return exerciseService.getAllExercises();
    }

    @GetMapping("/{id}")
    public ExerciseResponse getExerciseById(@PathVariable Long id){
        return exerciseService.getExerciseInfo(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ExerciseResponse createExercise(@Valid @RequestBody ExerciseRequest exerciseRequest){
        return exerciseService.createExercise(exerciseRequest);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ExerciseResponse updateExercise(@PathVariable Long id,@Valid @RequestBody ExerciseRequest exerciseRequest){
        return exerciseService.updateExercise(id, exerciseRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable Long id){
        exerciseService.deleteExerciseById(id);
    }
}
