package com.ap.gymtracker.service;

import com.ap.gymtracker.dto.ExerciseRequest;
import com.ap.gymtracker.dto.ExerciseResponse;
import com.ap.gymtracker.exception.ResourceNotFoundException;
import com.ap.gymtracker.model.Exercise;
import com.ap.gymtracker.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public List<ExerciseResponse> getAllExercises(){

          List<Exercise> exercises = exerciseRepository.findAll();
          List<ExerciseResponse> exerciseResponses = new ArrayList<>();
          for(Exercise exercise : exercises){
              exerciseResponses.add(new ExerciseResponse(exercise.getId(), exercise.getName(), exercise.getDescription()));
          }
          return exerciseResponses;
    }

    public Exercise getExerciseById(Long id){
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));
    }

    public ExerciseResponse getExerciseInfo(Long id){
        Exercise e =  getExerciseById(id);
                ExerciseResponse exerciseResponse = new ExerciseResponse(e.getId(), e.getName(), e.getDescription());
                return exerciseResponse;

    }

    public ExerciseResponse createExercise(ExerciseRequest exerciseRequest){
        Exercise exercise = new Exercise();
        exercise.setName(exerciseRequest.name());
        exercise.setDescription(exerciseRequest.description());
        Exercise saved = exerciseRepository.save(exercise);
        return new ExerciseResponse(saved.getId(), saved.getName(), saved.getDescription());
    }

    public ExerciseResponse updateExercise(Long id,ExerciseRequest exerciseRequest){
        Exercise exercise = getExerciseById(id);
        exercise.setName(exerciseRequest.name());
        exercise.setDescription(exerciseRequest.description());
        Exercise saved = exerciseRepository.save(exercise);
        return new ExerciseResponse(saved.getId(), saved.getName(), saved.getDescription());


    }
    public void deleteExerciseById(Long id){

        Exercise exercise = getExerciseById(id);
        exerciseRepository.delete(exercise);
    }
}
