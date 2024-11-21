package com.gigasea.learning_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gigasea.learning_management.model.Course;
import java.time.LocalDate;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Find courses by instructor name
    List<Course> findByInstructor(String instructor);

    // Find courses starting after a specific date
    List<Course> findByStartDateAfter(LocalDate date);

    // Find courses with a specific number of credits
    List<Course> findByCredits(int credits);
}
