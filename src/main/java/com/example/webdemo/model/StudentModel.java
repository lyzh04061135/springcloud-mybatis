package com.example.webdemo.model;

import lombok.Data;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Data
//@Entity
//@Table(name = "student", catalog = "demo", schema = "lyzh")
public class StudentModel {
//    @Id
    private String name;
    private String password;
}
