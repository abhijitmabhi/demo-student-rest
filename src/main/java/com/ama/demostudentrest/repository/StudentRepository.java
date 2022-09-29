package com.ama.demostudentrest.repository;

import com.ama.demostudentrest.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>();

    public List<Student> getStudents(){
        return students;
    }

    public Student getStudent(int id){
        return students.get(id);
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void updateStudent(Student student, int id){
        students.set(id,student);
    }

    public void deleteStudent(int id){
        students.remove(id);
    }

}
