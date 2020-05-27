package com.example.hystrixexamplestudentservice.controller;

import com.example.hystrixexamplestudentservice.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentServiceController {

    private static Map<String, List<Student>> schoolDB=new HashMap<>() ;

    static{
        schoolDB=new HashMap<String,List<Student>>();
        List<Student> list=new ArrayList<>();
        Student student=new Student("Sajal", "Class IV");
        list.add(student);
        student=new Student("Lokesh", "Class V");
        list.add(student);
        schoolDB.put("abcschool", list);
        list = new ArrayList<Student>();
        student = new Student("Kajal", "Class III");
        list.add(student);
        student = new Student("Sukesh", "Class VI");
        list.add(student);

        schoolDB.put("xyzschool", list);
    }

    @GetMapping("/getStudentDetailsForSchool/{schoolname}")
    public List<Student> getStudents(@PathVariable String schoolname) {
        System.out.println("Getting Student details for " + schoolname);

        List<Student> studentList = schoolDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }

}
