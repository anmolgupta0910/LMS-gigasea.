package com.gigasea.learning_management.repository;

import com.gigasea.learning_management.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
