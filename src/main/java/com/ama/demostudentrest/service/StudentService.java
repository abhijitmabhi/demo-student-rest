package com.ama.demostudentrest.service;

import com.ama.demostudentrest.pojo.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();
    public Student getStudent(String id);
    public void addStudent(Student student);
    public void updateStudent(Student student, String id);
    public void deleteStudent(String id);
}
