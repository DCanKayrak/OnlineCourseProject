package com.dcankayrak.OnlineClub.service;

import com.dcankayrak.OnlineClub.model.Student;
import com.dcankayrak.OnlineClub.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }
}
