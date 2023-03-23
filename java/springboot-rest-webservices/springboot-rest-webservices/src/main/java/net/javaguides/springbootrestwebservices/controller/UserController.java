package net.javaguides.springbootrestwebservices.controller;

import lombok.AllArgsConstructor;

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

    public  ResponseEntity<User> createUser(@RequestBody User user){

        User savedUser = userService.createUser(user);
        return  new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
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

    }
