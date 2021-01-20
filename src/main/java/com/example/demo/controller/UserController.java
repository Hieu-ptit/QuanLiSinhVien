package com.example.demo.controller;

import com.example.demo.models.entities.User;
import com.example.demo.models.in.UserCreate;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    private List<User> users = new ArrayList<User>();
    @GetMapping
    public List<User> read() {
        return service.read();
    }

    @PostMapping
    public User create(@RequestBody UserCreate userCreate) {
        return service.create(userCreate);
    }

    @PutMapping("/{id}")
    public String Update(@PathVariable("id") int id,@RequestBody User user){
        return service.Update(id,user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id ) {
        return service.delete(id);
    }

}
