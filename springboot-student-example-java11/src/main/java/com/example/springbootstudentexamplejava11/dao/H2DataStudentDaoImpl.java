package com.example.springbootstudentexamplejava11.dao;

import com.example.springbootstudentexamplejava11.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Repository
@Qualifier("H2Data")
public class H2DataStudentDaoImpl implements StudentDao {
    @Override
    public Collection<Student> getAllStudents() {
        return new ArrayList<Student>(){
            {
                add(new Student(1, "Nick Jones", "Film"));
                add(new Student(2, "Priyanka Chopra", "Law"));
            }
        };
    }

    @Override
    public Student getStudentById(Integer id) {
        return null;
    }

    @Override
    public void deleteStudentById(Integer id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
