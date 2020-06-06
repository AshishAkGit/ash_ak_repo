package com.example.springbootstudentexamplejava11.dao;

import com.example.springbootstudentexamplejava11.entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(Integer id);

    void deleteStudentById(Integer id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
