package com.gigasea.learning_management.controller;

import com.gigasea.learning_management.model.Assessment;
import com.gigasea.learning_management.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    // View all assessments
    @GetMapping("/assessments")
    public String listAssessments(Model model) {
        model.addAttribute("assessments", assessmentService.findAssessments());
        return "assessments";
    }

    // Register a new assessment
    @GetMapping("/registerAssessment")
    public String registerAssessment(Model model) {
        model.addAttribute("assessment", new Assessment());
        return "registerAssessment";
    }

    @PostMapping("/saveAssessment")
    public String saveAssessment(@ModelAttribute("assessment") Assessment assessment) {
        assessmentService.saveAssessment(assessment);
        return "redirect:/assessments";
    }

    // Update an assessment
    @GetMapping("/updateAssessment/{id}")
    public String updateAssessment(@PathVariable Long id, Model model) {
        Assessment assessment = assessmentService.getAssessmentById(id);
        model.addAttribute("assessment", assessment);
        return "updateAssessment";
    }

    @PostMapping("/updateAssessment")
    public String updateAssessment(@ModelAttribute("assessment") Assessment assessment) {
        assessmentService.updateAssessment(assessment);
        return "redirect:/assessments";
    }

    // Delete an assessment
    @GetMapping("/deleteAssessment/{id}")
    public String deleteAssessment(@PathVariable Long id) {
        assessmentService.deleteAssessment(id);
        return "redirect:/assessments";
    }
}
