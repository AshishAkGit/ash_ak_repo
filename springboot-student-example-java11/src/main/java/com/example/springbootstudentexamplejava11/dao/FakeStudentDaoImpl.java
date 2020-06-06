package com.example.springbootstudentexamplejava11.dao;

import com.example.springbootstudentexamplejava11.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("FakeData")
public class FakeStudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students;

    static{
                students=new HashMap<>() {
                 {
                    put(1,new Student(1,"Ashish Khadilkar","Computer"));
                    put(2,new Student(2,"Karan Raj","Electronics"));
                    put(3,new Student(3,"RamCharan Teja","Computer"));
                    put(4,new Student(4,"Sanket Khadilkar","IT"));
                    put(5,new Student(5,"Anna James","Maths"));
                }
            };
        }

    @Override
    public Collection<Student> getAllStudents(){
        return students.values();
    }
    @Override
    public Student getStudentById(Integer id){
        return students.get(id);
    }
    @Override
    public void deleteStudentById(Integer id){
        this.students.remove(id);
    }
    @Override
    public void updateStudent(Student student){
        Student newStudent =students.get(student.getId());
        newStudent.setName(student.getName());
        newStudent.setCourse(student.getCourse());
        students.put(student.getId(),newStudent);
    }
    @Override
    public void insertStudent(Student student){
        students.put(student.getId(),student);
    }

}

