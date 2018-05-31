package com.sample.spring.SampleSpring.services;


import com.sample.spring.SampleSpring.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static java.util.Collections.emptyList;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<com.sample.spring.SampleSpring.models.User> optionalUser = userRepository.findById(s);

        if (optionalUser == null) {
            throw new UsernameNotFoundException(s);
        }

        return new User(optionalUser.get().getUserId(), optionalUser.get().getPassword(), emptyList());
    }
}
