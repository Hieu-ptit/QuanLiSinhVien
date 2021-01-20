package com.example.demo.services;

import com.example.demo.models.entities.StudentClass;
import com.example.demo.models.entities.Students;
import com.example.demo.models.in.ClassCreate;
import com.example.demo.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class ClassService {
    @PersistenceContext
    protected EntityManager entityManager;
    @Autowired
    private ClassRepository classRepository;
    public List<StudentClass> Read(){
        return classRepository.findAll();
    }
//    List<StudenClass> std = new ArrayList<StudenClass>();
    public StudentClass Create(ClassCreate classCreate){
        StudentClass studentClass = new StudentClass();
        studentClass.setName(classCreate.getName());
        studentClass.setId(classCreate.getId());
        classRepository.save(studentClass);
//        std.add(studenClass);
//        for (StudenClass st:std
//             ) {
//            System.out.println(st);
//        }
        return studentClass;
    }

    public String delete(int id){
        StudentClass studentClass = classRepository.findById(id).orElse(null);
        if(studentClass == null) return "fail";
        classRepository.delete(studentClass);
        return "Success!";
    }

    public String update(int id, StudentClass sc){
        StudentClass studentClass = classRepository.findById(id).orElse(null);
        if(studentClass == null) return "fail";
        studentClass.setName(sc.getName());
        classRepository.save(studentClass);
        return "Success!";
    }

    public List<Students> Search(ClassCreate classCreate){
        String sql = "select * from student where 1 = 1";
        if(classCreate != null && classCreate.getId() != 0){
            sql = sql + " and class_id LIKE '%"+ classCreate.getId() +"%' " ;
        }
        Query query = entityManager.createNativeQuery(sql, Students.class);
        return query.getResultList();
    }
}
