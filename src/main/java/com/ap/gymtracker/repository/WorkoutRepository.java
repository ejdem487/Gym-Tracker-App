package com.ap.gymtracker.repository;
import com.ap.gymtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.ap.gymtracker.model.Workout;

import java.util.List;


public interface WorkoutRepository extends JpaRepository<Workout,Long>{
    Optional<Workout> findByIdAndUser(Long workoutId, User user);
    List<Workout> findAllByUser(User user);

}
