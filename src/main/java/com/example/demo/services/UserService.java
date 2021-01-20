package com.example.demo.services;

import com.example.demo.models.entities.User;
import com.example.demo.models.in.UserCreate;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> read() {
        return userRepository.findAll();
    }


    public User create(UserCreate userCreate) {

        User user = new User();

        user.setName(userCreate.getName());
        user.setAge(userCreate.getAge());
        user.setAddress(userCreate.getAddress());


        user = userRepository.save(user);

        return user;
    }
    public String Update(int id,User us) {
        User user = userRepository.findById(id).orElse(null);
        if (user.getId() == us.getId()) {
            user.setName(us.getName());
            user.setAddress(us.getAddress());
            user.setAge(us.getAge());
        }
        userRepository.save(user) ;
        return "Success !";
    }
    public String delete(int id) {

        User user = userRepository.findById(id).orElse(null);
        if (user == null) return "Fail !";

        userRepository.delete(user);

        return "Success !";
    }
}
