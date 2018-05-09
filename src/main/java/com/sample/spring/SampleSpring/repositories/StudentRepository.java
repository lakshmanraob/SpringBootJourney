package com.sample.spring.SampleSpring.repositories;

import com.sample.spring.SampleSpring.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
