package com.TaskManagementSystem.TaskManagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Content_Controller {
    // for security purpose

    //@PreAuthorize("hasRole('normal')")
    @GetMapping("/normaluser")
    public ResponseEntity<String> normaluser(){
        return ResponseEntity.ok(" welcome to user page....");
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("welcome to our system ...");
    }

    //@PreAuthorize("hasRole('Admin')")
    @GetMapping("/adminUser")
    public ResponseEntity<String> adminuser(){
        return ResponseEntity.ok("welcome to admin page ....");
    }

    }

