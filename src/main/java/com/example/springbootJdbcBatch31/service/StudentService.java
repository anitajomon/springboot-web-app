package com.example.springbootJdbcBatch31.service;

import com.example.springbootJdbcBatch31.model.Student;
import com.example.springbootJdbcBatch31.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void insertData(Student student){
        studentRepository.save(student);
    }
    public List<Student>getStudent(){
        return studentRepository.findAll();
    }
    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }
    public void UpdateStudent(Student student, int id){
        student.setId(id);
        studentRepository.save(student);
    }
    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
}
