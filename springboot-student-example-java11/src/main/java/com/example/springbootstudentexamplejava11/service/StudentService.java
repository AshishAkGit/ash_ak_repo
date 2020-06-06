package com.example.springbootstudentexamplejava11.service;

import com.example.springbootstudentexamplejava11.dao.StudentDao;
import com.example.springbootstudentexamplejava11.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    @Qualifier("H2Data")
    StudentDao studentDao;


    public Collection<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
    public Student getStudentById(Integer id){
        return studentDao.getStudentById(id);
    }
    public void deleteStudentById(Integer id){
         studentDao.deleteStudentById(id);
    }
    public void updateStudent(Student student){
        studentDao.updateStudent(student);
    }
    public void insertStudent(Student student){
        studentDao.insertStudent(student);
    }


}
