package com.example.Spring.Security.Students;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private List<Student> students = Arrays.asList(
      new Student(1, "tofayel"),
      new Student(2, "Taj"),
      new Student(3, "Ahad")

    );

    @GetMapping(path = "{studentId}")
    public Student findStudentById(@PathVariable int studentId){

        for(Student s : students){
            if(s.getId() == studentId){
                return s;
            }
        }
        return null;
    }

    @GetMapping("/text")
    public String getText(){
        return "here is your text";
    }







}
