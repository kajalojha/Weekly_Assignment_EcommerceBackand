package com.TaskManagementSystem.TaskManagement.Service;

import com.TaskManagementSystem.TaskManagement.Repository.UserRepository;
import com.TaskManagementSystem.TaskManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public static List<User> getUsers(UserRepository userRepository){ // to get all users
        return userRepository.findAll();
    }
    public void addNewUser(User user){ // add new user
        Optional<User> usersByEmail = userRepository.findUsersByEmail(user.getUser_email());
        if(usersByEmail.isPresent()){
            throw new IllegalStateException("email is taken..");
        }
        userRepository.save(user);
        System.out.println("user created");
    }
    public static void deleteUser(Integer id , UserRepository userRepository){// to delete user
        boolean b = userRepository.existsById(id);
        if(!b){
            throw new IllegalStateException("user does not exist");
        }
        userRepository.deleteById(id);

    }

}
