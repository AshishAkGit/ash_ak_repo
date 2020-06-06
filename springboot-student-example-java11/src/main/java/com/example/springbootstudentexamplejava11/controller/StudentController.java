package com.example.springbootstudentexamplejava11.controller;

import com.example.springbootstudentexamplejava11.entity.Student;
import com.example.springbootstudentexamplejava11.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping()
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        studentService.deleteStudentById(id);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
}
