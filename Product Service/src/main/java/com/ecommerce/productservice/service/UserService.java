package com.ecommerce.productservice.service;

import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.models.UserDemo;
import com.ecommerce.productservice.repository.InstructorRepository;
import com.ecommerce.productservice.repository.LearnerRepository;
import com.ecommerce.productservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    private final InstructorRepository instructorRepository;

    private final LearnerRepository learnerRepository;



    UserService(UserRepository userRepository, InstructorRepository instructorRepository, LearnerRepository learnerRepository){
        this.userRepository  =  userRepository;
        this.instructorRepository  = instructorRepository;
        this.learnerRepository = learnerRepository;
    }

    public User createUser(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    public Optional<User> getUserByName(String name){
        return  userRepository.findByName(name);
    }

    public Optional<User> getUserById(Long id){
        return  userRepository.findById(id);
    }

    public  Optional<Instructor> geInstructorByName(String name){
        return  instructorRepository.findByName(name);
    }

    public  Optional<Learner> getLearnerByName(String name){
        return  learnerRepository.findByName(name);
    }

    public Instructor createInstructor(String name, String email){
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);
        instructor.setSalary(3000);
        instructor.setSkill("Java Developer");
        instructorRepository.save(instructor);

        return instructor;
    }

    public Learner createLearner(String name, String email){
        Learner l = new Learner();
        l.setName(name);
        l.setEmail(email);
        l.setUniversity("RGPV");
        l.setPsp(20.00);
        learnerRepository.save(l);
        return l;
    }
//    public List<User> getAllUser(){
//        return userRepository.getAllUser();
//    }
}
