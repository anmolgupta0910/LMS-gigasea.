package com.gigasea.learning_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.gigasea.learning_management.model.Course;
import com.gigasea.learning_management.service.CourseService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Display all courses
    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", courseService.findCourses());
        return "courses";
    }

    // Show form to register a new course
    @GetMapping("/registerCourse")
    public String registerCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "registerCourse";
    }

    // Save a course to the database
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    // Show form to update an existing course
    @GetMapping("/updateCourse/{id}")
    public String updateCourse(Model model, @PathVariable Long id) {
        Course course = courseService.getCourseId(id);
        model.addAttribute("course", course);
        return "updateFormCourse";
    }

    // Delete a course by ID
    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

    // New endpoint: Filter courses by instructor
    @GetMapping("/coursesByInstructor")
    public String coursesByInstructor(@RequestParam("instructor") String instructor, Model model) {
        List<Course> courses = courseService.findCoursesByInstructor(instructor);
        model.addAttribute("courses", courses);
        return "courses";
    }

    // New endpoint: Filter courses by credits
    @GetMapping("/coursesByCredits")
    public String coursesByCredits(@RequestParam("credits") int credits, Model model) {
        List<Course> courses = courseService.findCoursesByCredits(credits);
        model.addAttribute("courses", courses);
        return "courses";
    }

    // New endpoint: Filter courses starting after a specific date
    @GetMapping("/coursesStartingAfter")
    public String coursesStartingAfter(@RequestParam("date") String date, Model model) {
        LocalDate startDate = LocalDate.parse(date); // Parse date from request
        List<Course> courses = courseService.findCoursesStartingAfter(startDate);
        model.addAttribute("courses", courses);
        return "courses";
    }
}
