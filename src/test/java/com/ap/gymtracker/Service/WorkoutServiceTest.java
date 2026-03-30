package com.ap.gymtracker.service;

import com.ap.gymtracker.model.Workout;
import com.ap.gymtracker.repository.WorkoutRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WorkoutServiceTest {

    @Mock
    WorkoutRepository workoutRepository;

    @InjectMocks
    WorkoutService workoutService;

    @Test
    void updateWorkoutShouldChangeWorkoutFields() {
        Workout existingWorkout = new Workout();
        existingWorkout.setId(1L);
        existingWorkout.setName("Push Day");
        existingWorkout.setDate(LocalDate.of(2026, 3, 1));
        existingWorkout.setNotes("Old notes");

        Workout updatedWorkout = new Workout();
        updatedWorkout.setName("Leg Day");
        updatedWorkout.setDate(LocalDate.of(2026, 3, 30));
        updatedWorkout.setNotes("New notes");

        when(workoutRepository.findById(1L)).thenReturn(Optional.of(existingWorkout));
        when(workoutRepository.save(existingWorkout)).thenReturn(existingWorkout);

        Workout result = workoutService.updateWorkout(1L, updatedWorkout);

        assertEquals("Leg Day", result.getName());
        assertEquals(LocalDate.of(2026, 3, 30), result.getDate());
        assertEquals("New notes", result.getNotes());
    }
}
