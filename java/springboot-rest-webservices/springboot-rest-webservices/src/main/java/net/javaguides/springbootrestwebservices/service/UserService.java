package net.javaguides.springbootrestwebservices.service;

import net.javaguides.springbootrestwebservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();


}


