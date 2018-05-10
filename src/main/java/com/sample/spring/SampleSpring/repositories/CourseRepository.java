package com.sample.spring.SampleSpring.repositories;

import com.sample.spring.SampleSpring.models.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
