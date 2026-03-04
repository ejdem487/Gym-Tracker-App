package com.ap.gymtracker.repository;
import com.ap.gymtracker.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkoutRepository extends JpaRepository<Workout,Long>{
}
