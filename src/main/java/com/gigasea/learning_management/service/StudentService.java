package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Student;
import java.util.List;

public interface StudentService {

    // Existing methods
    void saveStudent(Student student);
    List<Student> findStudents();
    Student getStudentId(Long id);
    void deleteStudent(Long id);
    void deleteAllStudents(); // Add this method to delete all students
    void addCourseToStudent(Long studentId, Long courseId);

    // New method to get students by gender
    List<Student> getStudentsByGender(String gender);  // New method
}
