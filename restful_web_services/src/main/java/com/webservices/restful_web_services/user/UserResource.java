package com.webservices.restful_web_services.user;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Rest Api
@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    //Retrieve all users Rest api
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findALl();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

   @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = service.save(user);
       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
       return ResponseEntity.created(location).build();
   }

}
