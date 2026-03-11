package com.ap.gymtracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.gymtracker.model.Workout;



public interface WorkoutRepository extends JpaRepository<Workout,Long>{
}
