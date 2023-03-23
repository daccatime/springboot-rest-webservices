package net.javaguides.springbootrestwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestwebservices.dto.UserDto;
import net.javaguides.springbootrestwebservices.entity.User;
import net.javaguides.springbootrestwebservices.repository.UserRepository;
import net.javaguides.springbootrestwebservices.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

// update the method to reflect
// the method in the user service


public class UserServiceImpl implements UserService {
   private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        // convert user dto to jpa method
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );


     User savedUser =     userRepository.save(user);

     UserDto savedUserDto = new UserDto(

             savedUser.getId(),
             savedUser.getFirstName(),
             savedUser.getLastName(),
             savedUser.getEmail()
     );

    return savedUserDto;
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser =  userRepository.save(existingUser);

        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
