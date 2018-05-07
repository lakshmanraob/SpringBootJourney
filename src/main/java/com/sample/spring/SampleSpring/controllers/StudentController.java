package com.sample.spring.SampleSpring.controllers;

import com.sample.spring.SampleSpring.models.Course;
import com.sample.spring.SampleSpring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
public class StudentController {

    @Autowired
    public StudentService studentService;


    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity getStudentEnrolledCourses(@PathVariable String studentId) {
        return ResponseEntity.ok(studentService.retrieveAllCourses(studentId));
    }

    @GetMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity retrieveDetailsForCourse(@PathVariable String studentId, @PathVariable String courseId) {
        return ResponseEntity.ok(studentService.retrieveCourse(studentId, courseId));
    }

    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<Course> registerStudentForCourse(@PathVariable String studentId, @RequestBody Course newCourse) {
        Course course = studentService.addCourse(studentId, newCourse);

        if (course == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(course.getCourse_id()).toUri();

        return ResponseEntity.created(location).body(course);
    }
}
