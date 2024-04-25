package com.TaskManagementSystem.TaskManagement.Controller;

import com.TaskManagementSystem.TaskManagement.Repository.UserRepository;
import com.TaskManagementSystem.TaskManagement.Service.UserService;
import com.TaskManagementSystem.TaskManagement.entity.Product;
import com.TaskManagementSystem.TaskManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("user_table")
//@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    // get All users
    @GetMapping("/user")
    public List<User> getAllUser(){
        List<User> userList= userRepository.findAll();
        return userList;
    }

    // find student by id
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id){
        User user = userRepository.findById(id).get();
        return user;
    }

    // to add new user
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }


    // to update user based on their id
    @PutMapping("/user/update/{id}")
    public User updateUser(@PathVariable Integer id){
        User user = userRepository.findById(id).get();
//        user.setUser_id(29);
        user.setUser_name("kajal");
        userRepository.save(user);
        return user;
    }

    // to delete user
    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }



//    @GetMapping("/public")
//    public String publicUser(){
//        return "public user...";
//    }




}
