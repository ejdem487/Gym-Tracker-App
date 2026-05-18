package com.ap.gymtracker.service;
import com.ap.gymtracker.model.User;
import com.ap.gymtracker.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ap.gymtracker.model.Workout;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkouts(User user){
        return workoutRepository.findAllByUser(user);
    }

    public Workout createWorkout(Workout workout, User user){
        workout.setUser(user);
        return workoutRepository.save(workout);
    }

    public Workout getWorkoutById(Long id, User user){
        return workoutRepository.findByIdAndUser(id,user)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
    }

    public void deleteWorkoutById(Long id, User user){
        Workout workout = getWorkoutById(id, user);
        workoutRepository.delete(workout);
    }

    public Workout updateWorkout(Long id,Workout updated, User user){
        Workout existing = getWorkoutById(id,user);
        existing.setName(updated.getName());
        existing.setNotes(updated.getNotes());
        existing.setDate(updated.getDate());
        return workoutRepository.save(existing);

    }
}
