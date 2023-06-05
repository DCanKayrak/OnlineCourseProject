package com.dcankayrak.OnlineClub.controller;

import com.dcankayrak.OnlineClub.dto.StudentCreateRequest;
import com.dcankayrak.OnlineClub.model.Student;
import com.dcankayrak.OnlineClub.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.NotBoundException;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return ResponseEntity.ok(this.studentService.getStudent(id));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentCreateRequest request){
        return ResponseEntity.ok(this.studentService.createStudent(request));
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id){
        this.studentService.deleteStudent(id);
    }
}
