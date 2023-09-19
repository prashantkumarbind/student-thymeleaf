package com.webapplication.dao;

import com.webapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, String> {

        public List<Student> findByName(String name);
}
