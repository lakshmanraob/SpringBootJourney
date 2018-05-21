package com.sample.spring.SampleSpring.repositories;


import com.sample.spring.SampleSpring.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<User, String> {

    UserDetails findByUserName(String userName);

}