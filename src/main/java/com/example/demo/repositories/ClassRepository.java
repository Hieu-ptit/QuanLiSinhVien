package com.example.demo.repositories;

import com.example.demo.models.entities.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<StudentClass,Integer> {
}
