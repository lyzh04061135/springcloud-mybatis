package com.example.webdemo.controller;

import com.example.webdemo.model.StudentModel;
import com.example.webdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(path = "getStudents")
    public String getStudents() {
        List<StudentModel> studentModels = studentService.getStudents();
        StringBuilder stringBuilder = new StringBuilder();
        if (null != studentModels) {
            for (StudentModel model : studentModels) {
                stringBuilder.append(model.getName() + ",");
            }
        }

        return stringBuilder.toString();
    }

    @RequestMapping(path = "hello")
    public String hello() {
        return "world";
    }

    public static void main(String[] args) {

    }
}
