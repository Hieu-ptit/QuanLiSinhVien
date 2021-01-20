package com.example.demo.controller;

import com.example.demo.models.entities.StudentClass;
import com.example.demo.models.entities.Students;
import com.example.demo.models.in.ClassCreate;
import com.example.demo.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
   
    @Autowired
    private ClassService classService;
    List<StudentClass> studentClass = new ArrayList<StudentClass>();
    @GetMapping
    public List<StudentClass> Read(){
        return classService.Read();
    }
    @PostMapping
    public StudentClass Create(@RequestBody ClassCreate classCreate){
        return classService.Create(classCreate);
    }
    @DeleteMapping("/{id}")
    public String Delete(@PathVariable("id") int id){
        return classService.delete(id);
    }
    @PutMapping("/{id}")
    public  String Update(@PathVariable("id") int id,@RequestBody StudentClass studentClass){
        return classService.update(id, studentClass);
    }
    @GetMapping("/{id}")
    public List<Students> searchId(@PathVariable("id") int id){
        ClassCreate classCreate = new ClassCreate();
        classCreate.setId(id);
        return classService.Search(classCreate);
    }

}
