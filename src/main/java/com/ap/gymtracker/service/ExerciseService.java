package com.ap.gymtracker.service;

import com.ap.gymtracker.model.Exercise;
import com.ap.gymtracker.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Long id){
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
    }

    public Exercise createExercise(Exercise exercise){
        return exerciseRepository.save(exercise);
    }
    public Exercise updateExercise(Long id, Exercise updated){
        Exercise existing =  getExerciseById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        return exerciseRepository.save(existing);

    }
    public void deleteExerciseById(Long id){
        exerciseRepository.deleteById(id);
    }
}
