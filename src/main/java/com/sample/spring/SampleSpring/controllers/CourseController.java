package com.sample.spring.SampleSpring.controllers;

import com.sample.spring.SampleSpring.models.Course;
import com.sample.spring.SampleSpring.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(method = RequestMethod.POST, value = "/courses/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return ResponseEntity.ok(course);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    @RequestMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseInfo(@PathVariable String id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            return ResponseEntity.ok(optionalCourse.get());
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/courses/search/{courseStr}")
    public ResponseEntity<List<Course>> search(@PathVariable String courseStr) {
        return ResponseEntity.ok(mongoTemplate.find(Query.query(new Criteria()
                .orOperator(Criteria.where("course_name").regex(courseStr, "i"))
        ), Course.class));
    }

}
