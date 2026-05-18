package com.ap.gymtracker.repository;

import com.ap.gymtracker.model.User;
import com.ap.gymtracker.model.WorkoutExercise;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise,Long> {
     Optional<WorkoutExercise> findOneByWorkout_IdAndWorkout_User(Long workoutId, User user);

     List<WorkoutExercise> findByWorkout_IdAndWorkout_User(Long workoutId, User user);

     Optional<WorkoutExercise> findByIdAndWorkout_User(Long id, User user);


}
