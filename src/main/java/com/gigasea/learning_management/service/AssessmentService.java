package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Assessment;
import java.util.List;

public interface AssessmentService {
    void saveAssessment(Assessment assessment);
    List<Assessment> findAssessments();
    Assessment getAssessmentById(Long id);
    void deleteAssessment(Long id);
    void updateAssessment(Assessment assessment);
}
