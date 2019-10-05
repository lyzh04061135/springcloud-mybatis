package com.example.webdemo.dao;

import com.example.webdemo.model.StudentModel;

import java.util.List;

public interface StudentDao {
    List<StudentModel> getStudents();
}
