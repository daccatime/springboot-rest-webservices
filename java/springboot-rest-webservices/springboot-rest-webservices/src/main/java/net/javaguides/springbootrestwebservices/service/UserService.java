package net.javaguides.springbootrestwebservices.service;

import net.javaguides.springbootrestwebservices.dto.UserDto;
import net.javaguides.springbootrestwebservices.entity.User;

import java.util.List;
// this is the first place for a  change to be made
public interface UserService {
    UserDto createUser(UserDto user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser (User user) ;

    void deleteUser (Long userId);




}


