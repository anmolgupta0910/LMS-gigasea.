package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseService {
    // Save a course to the database
    void saveCourse(Course course);

    // Retrieve all courses
    List<Course> findCourses();

    // Find a course by its ID
    Course getCourseId(Long id);

    // Delete a course by its ID
    void deleteCourse(Long id);

    // Delete all courses
    void deleteAllCourses();

    // New methods for handling the updated Course fields
    List<Course> findCoursesByInstructor(String instructor); // Find courses by instructor name
    List<Course> findCoursesByCredits(int credits);          // Find courses by credits
    List<Course> findCoursesStartingAfter(LocalDate date);   // Find courses starting after a specific date
}
