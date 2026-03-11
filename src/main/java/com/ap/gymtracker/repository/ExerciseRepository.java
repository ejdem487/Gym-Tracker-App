package com.ap.gymtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ap.gymtracker.model.Exercise;
public interface ExerciseRepository extends JpaRepository<Exercise,Long> {

}
