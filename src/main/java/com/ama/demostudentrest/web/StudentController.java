package com.ama.demostudentrest.web;

import com.ama.demostudentrest.pojo.Student;
import com.ama.demostudentrest.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Student Controller", description = "Create and retrieve students")
public class StudentController {
    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @Operation(summary = "Get students", description = "Get all students")
    @GetMapping("/student/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id){
        Student student = studentService.getStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<HttpStatus> postStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @Valid @RequestBody Student student){
        studentService.updateStudent(student,id);
        return new ResponseEntity<>(studentService.getStudent(id),HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
