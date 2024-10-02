package com.mindhub.app_courses.config;

import com.mindhub.app_courses.models.Admin;
import com.mindhub.app_courses.models.Person;
import com.mindhub.app_courses.models.Teacher;
import com.mindhub.app_courses.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username));
//        if (person instanceof Admin){
//            return new User(person.getEmail(), person.getPassword(), AuthorityUtils.createAuthorityList("ADMIN"));
//        }
//        if (person instanceof Teacher){
//            return new User(person.getEmail(), person.getPassword(), AuthorityUtils.createAuthorityList("TEACHER"));
//        }
        return new User(person.getEmail(), person.getPassword(), AuthorityUtils.createAuthorityList(person instanceof Admin ? "ADMIN" : person instanceof Teacher ? "TEACHER" : "STUDENT"));
    }
}
