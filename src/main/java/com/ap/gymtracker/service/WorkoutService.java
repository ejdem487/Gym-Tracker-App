package com.ap.gymtracker.service;
import com.ap.gymtracker.model.Workout;
import com.ap.gymtracker.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.RuntimeErrorException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }
    public Workout createWorkout(Workout workout){
        return workoutRepository.save(workout);
    }

    public Workout getWorkoutById(Long id){
        return workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
    }

    public void deleteWorkoutById(Long id){
        workoutRepository.deleteById(id);
    }

    public Workout updateWorkout(Long id,Workout updated){
        Workout existing = getWorkoutById(id);
        existing.setName(updated.getName());
        existing.setDate(updated.getDate());
        existing.setNotes(updated.getNotes());
        return workoutRepository.save(existing);
    }
}
