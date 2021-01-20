package com.example.demo.controller;

import com.example.demo.models.entities.Students;
import com.example.demo.models.in.StudentCreate;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentsController {
    @Autowired
    private StudentService studentService;

    private List<Students> students = new ArrayList<Students>();

    @GetMapping
    public List<Students> read(){
        return studentService.Read();
    }

    @PostMapping
    public Students create(@RequestBody StudentCreate studentCreate){
        return studentService.Create(studentCreate);
    }

    @PutMapping("/{id}")
    public String Update(@PathVariable("id") int id,@RequestBody StudentCreate studentCreate){
       return studentService.Update(id,studentCreate);
    }
    @DeleteMapping("/{id}")
    public String Delete(@PathVariable("id") int id){
        return studentService.delete(id);
    }
}
