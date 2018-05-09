package com.sample.spring.SampleSpring.repositories;

import com.sample.spring.SampleSpring.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
