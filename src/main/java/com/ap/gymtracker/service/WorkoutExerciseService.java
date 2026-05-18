package com.ap.gymtracker.service;

import com.ap.gymtracker.model.Exercise;
import com.ap.gymtracker.model.User;
import com.ap.gymtracker.model.Workout;
import com.ap.gymtracker.model.WorkoutExercise;
import com.ap.gymtracker.repository.ExerciseRepository;
import com.ap.gymtracker.repository.WorkoutExerciseRepository;
import com.ap.gymtracker.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutExerciseService{
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;

    public List<WorkoutExercise> findByWorkoutId(Long workoutId, User user) {
        return workoutExerciseRepository.findByWorkout_IdAndWorkout_User(workoutId, user);
    }

    public WorkoutExercise addExerciseToWorkout(Long workoutId,User user, Long exerciseId, Integer sets, Integer reps, Integer weight){
        Workout workout = workoutRepository.findByIdAndUser(workoutId,user)
                .orElseThrow(() -> new RuntimeException("Workout not find"));
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new RuntimeException("Exercise not find"));

        WorkoutExercise we = new WorkoutExercise();
        we.setWorkout(workout);
        we.setExercise(exercise);
        we.setSets(sets);
        we.setReps(reps);
        we.setWeight(weight);
        return workoutExerciseRepository.save(we);
    }

    public void removeExerciseFromWorkout(Long id, User user) {
        workoutExerciseRepository.findByIdAndWorkout_User(id, user).orElseThrow(() -> new RuntimeException("Workout not find"));
        workoutExerciseRepository.deleteById(id);
    }

    public WorkoutExercise getWorkoutExerciseById(Long id, User user){
        return workoutExerciseRepository.findByIdAndWorkout_User(id, user).orElseThrow(() -> new RuntimeException("Workout not find"));
    }

    public WorkoutExercise updateWorkoutExercise(Long id,User user, WorkoutExercise updated) {
        WorkoutExercise existing =  getWorkoutExerciseById(id, user);
        existing.setExercise(updated.getExercise());
        existing.setSets(updated.getSets());
        existing.setReps(updated.getReps());
        existing.setWeight(updated.getWeight());
        return workoutExerciseRepository.save(existing);
    }
}
