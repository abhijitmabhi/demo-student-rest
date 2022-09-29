package com.ama.demostudentrest.service;

import com.ama.demostudentrest.exception.ContactNotFoundException;
import com.ama.demostudentrest.pojo.Student;
import com.ama.demostudentrest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    @Override
    public Student getStudent(String id) {
        return studentRepository.getStudent(findIndexById(id));
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public void updateStudent(Student student, String id) {
        studentRepository.updateStudent(student,findIndexById(id));
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteStudent(findIndexById(id));
    }
    private int findIndexById(String id){
        return IntStream.range(0,studentRepository.getStudents().size())
                .filter(index -> studentRepository.getStudents().get(index).getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException(id));
    }
}
