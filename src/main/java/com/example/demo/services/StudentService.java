package com.example.demo.services;

import com.example.demo.models.entities.StudentClass;
import com.example.demo.models.entities.Students;
import com.example.demo.models.in.StudentCreate;
import com.example.demo.repositories.ClassRepository;
import com.example.demo.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
   @Autowired
   private StudentsRepository studentsRepository;
   @Autowired
   private ClassRepository classRepository;
   public List<Students> Read(){
       return studentsRepository.findAll();
    }

    public Students Create(StudentCreate studentCreate){
       Students students = new Students();

       students.setName(studentCreate.getName());
       students.setBirthday(studentCreate.getBirthday());
       students.setAddress((studentCreate.getAddress()));
       students.setPhone(studentCreate.getPhone());

       StudentClass studentClass = classRepository.findById(studentCreate.getClassId()).orElse(null);

       students.setStudentClass(studentClass);

       studentsRepository.save(students);
       return students;
    }

    public String delete(int id){
       Students students = studentsRepository.findById(id).orElse(null);
       if(students == null){
           return "fail";
       }
       studentsRepository.delete(students);
       return "Success!";
    }

    public String Update(int id,StudentCreate studentCreate){
       Students students = studentsRepository.findById(id).orElse(null);
       if(students == null) return "fail";
       students.setName(studentCreate.getName());
       students.setBirthday(studentCreate.getBirthday());
       students.setAddress(studentCreate.getAddress());
       students.setPhone(studentCreate.getPhone());

       StudentClass studentClass = classRepository.findById(studentCreate.getClassId()).orElse(null);
       students.setStudentClass(studentClass);
       studentsRepository.save(students);
       return "Success!";
    }
}
