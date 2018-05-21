package com.sample.spring.SampleSpring.services;


import com.sample.spring.SampleSpring.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static java.util.Collections.emptyList;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserDetails user = userRepository.findByUserName(s);

        if (user == null) {
            throw new UsernameNotFoundException(s);
        }

        return new User(user.getUsername(), user.getPassword(), emptyList());
    }
}
