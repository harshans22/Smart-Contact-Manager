package com.scm.scm20.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.scm20.entities.User;
import com.scm.scm20.helper.ResourceNotFoundException;
import com.scm.scm20.repositories.UserRepo;
import com.scm.scm20.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        String userId=UUID.randomUUID().toString();
        user.setUserId(userId);
        //password encode
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String userId) {
       return userRepo.findById(userId);
    }

    @Override
    public Optional<User> updateUser(User user) {

        //fetch user
        User user2=userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("User not found"));

        //update user
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setProfileLink(user.getProfileLink());
        user2.setProvider(user.getProvider());
        user2.setProvideruserId(user.getProvideruserId());

        //save user
        User save=userRepo.save(user2);
        return Optional.of(save);


    }

    @Override
    public void deleteUser(String userId) {
        User user2=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user2=userRepo.findById(userId).orElse(null);
        return user2!=null?true:false;

    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user=userRepo.findByEmail(email).orElse(null);
        return user!=null?true:false;
    }

    @Override
    public boolean isUserExistByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isUserExistByName'");
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    
    
}
