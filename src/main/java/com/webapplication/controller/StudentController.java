package com.webapplication.controller;

import com.webapplication.entity.Student;
import com.webapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {
        public static String nameValue;
        @Autowired
        StudentService sService;

        @GetMapping("/")
        public String studentDetails(Model model){
                model.addAttribute("studentallobject",sService.select());
                return "all.html";
        }

        @GetMapping("/addnew")
        public String addNewStudent(Model model){
                Student student = new Student();
                model.addAttribute("student", student);
                return "addstudent.html";
        }

        @PostMapping("/save")
        public String save(@ModelAttribute("student") Student student){
               sService.insert(student);
               return "redirect:/";
        }

        @GetMapping("update/{roll}")
        public String update(@PathVariable("roll") String roll,Model model){
                Student student = new Student();
                student = sService.getById(roll);
                model.addAttribute("student", student);
                return "update.html";
        }
        /*  check information by name==== ========  ======= ======== ======*/
        @GetMapping("/byname")
        public String byName(Model model){
                Student student = new Student();
                model.addAttribute("student",student);
                return "byname.html";
        }

        @PostMapping("/getnameobject")
        public String getName(@ModelAttribute("student") Student student){
                nameValue = student.getName();
                return "redirect:/searchbyname";
        }
        @GetMapping("/searchbyname")
        public String searchByName(Model model){
                Student student = new Student();
                model.addAttribute("student", sService.getByName(nameValue));
                return "searchbyname.html";
        }
        /*  end check my name========================*/
        @ResponseBody //response body only return data
        @GetMapping("/testing/{name}")
        public String testing(@PathVariable("name") String name){
               return "Your name is::"+name;
        }
}
