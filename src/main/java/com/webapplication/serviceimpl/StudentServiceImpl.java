package com.webapplication.serviceimpl;

import com.webapplication.dao.StudentDao;
import com.webapplication.entity.Student;
import com.webapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao sd;
    @Override
    public Student insert(Student student) {

            return sd.save(student);
    }

    @Override
    public List<Student> select() {
        List<Student> list = sd.findAll();
        return list;
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(String roll) {

    }

    @Override
    public List<Student> getByName(String name) {
        List<Student> list = sd.findByName(name);
        return list;
    }

    @Override
    public List<Student> getByClass() {
        return null;
    }

    @Override
    public Student getById(String roll) {
        Student s;
        Optional<Student> opt = sd.findById(roll);
        if(opt.isPresent())
        {
            return s =  opt.get();
        }
        return null;
    }
}
