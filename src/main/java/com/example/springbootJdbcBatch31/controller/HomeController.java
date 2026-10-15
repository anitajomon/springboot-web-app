package com.example.springbootJdbcBatch31.controller;

import com.example.springbootJdbcBatch31.model.Student;
import com.example.springbootJdbcBatch31.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class HomeController {
    @Autowired
    StudentService studentService;
    @GetMapping("/student")
    public String Home(Model model){
        model.addAttribute("std",new Student());
        return "student";
    }
    @PostMapping("/send")
    public String SaveDAta( Student student) throws IOException {
        studentService.insertData(student);
        return "redirect:/";
    }
    @GetMapping("/")
    public String ListStudent(Model model){
        model.addAttribute("stud",studentService.getStudent());
        return "index";
    }
    @GetMapping("/update/{id}")
    public String ShowUpdateStudent(@PathVariable int id, Model model) throws IOException {

        model.addAttribute("updateStudent",studentService.getStudentById(id));
        return "updateStudent";
    }
    @PostMapping("/updated/{id}")
    public String UpdateStudent(@PathVariable int id,Student student) throws IOException {
        student.setId(id);
        studentService.UpdateStudent(student,id);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
