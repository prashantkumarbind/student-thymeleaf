package com.webapplication.service;

import com.webapplication.entity.Student;

import java.util.List;

public interface StudentService {

        public Student insert(Student student);
        public List<Student> select();
        public void update(Student student);
        public void delete(String roll);
        public List<Student> getByName(String name);
        public List<Student> getByClass();
        public Student getById(int roll);
}
