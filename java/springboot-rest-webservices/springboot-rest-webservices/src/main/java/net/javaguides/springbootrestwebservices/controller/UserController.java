package net.javaguides.springbootrestwebservices.controller;

import lombok.AllArgsConstructor;

import net.javaguides.springbootrestwebservices.dto.UserDto;
import net.javaguides.springbootrestwebservices.entity.User;
import net.javaguides.springbootrestwebservices.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
// build create User Rest API
    @PostMapping

    public  ResponseEntity<UserDto> createUser(@RequestBody UserDto user){

        UserDto savedUser = userService.createUser(user);
        return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }
        // build get user by id rest api

    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
            User user = userService.getUserById(userId);
            return new ResponseEntity<>(user,HttpStatus.OK);

        }

        //build get all users Rest API
        // http://localhost:8080/api/users/
@GetMapping
        public ResponseEntity<List<User>> getAllUsers(){
        List<User> users= userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);

        }

        //build update user REST API
    @PutMapping("{id}")
        public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                               @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);

             return new ResponseEntity<>(updatedUser,HttpStatus.OK);

        }

        //build delete User Rest api
        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
            userService.deleteUser(userId);
            return new ResponseEntity<>("record dleted", HttpStatus.OK);
        }

}
