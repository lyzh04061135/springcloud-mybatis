package com.example.webdemo.service;

import com.example.webdemo.dao.StudentDao;
import com.example.webdemo.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<StudentModel> getStudents() {
        return studentDao.getStudents();
    }
}
