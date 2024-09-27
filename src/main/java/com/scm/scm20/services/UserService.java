package com.scm.scm20.services;

import java.util.List;
import java.util.Optional;

import com.scm.scm20.entities.User;

public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(String userId);
    Optional<User> updateUser(User user);
    void deleteUser(String userId);
    boolean isUserExist(String userId);
    boolean isUserExistByEmail(String email);
    boolean isUserExistByName(String name);
    List<User> getAllUsers();

    
}
