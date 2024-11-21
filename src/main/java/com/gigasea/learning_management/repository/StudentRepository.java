package com.gigasea.learning_management.repository;

import com.gigasea.learning_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // New method to find students by gender
    List<Student> findByGender(String gender);

}
