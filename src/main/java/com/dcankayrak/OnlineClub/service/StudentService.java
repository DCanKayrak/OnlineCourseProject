package com.dcankayrak.OnlineClub.service;

import com.dcankayrak.OnlineClub.dto.StudentCreateRequest;
import com.dcankayrak.OnlineClub.model.Student;
import com.dcankayrak.OnlineClub.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    public Student getStudent(Long id){
        return this.studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(StudentCreateRequest request) {
        Student newStudent = Student
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .build();
        this.studentRepository.save(newStudent);
        return newStudent;
    }

    public void deleteStudent(Long id) {
        Student student = this.studentRepository.findById(id).orElse(null);
        if(student != null){
            this.studentRepository.deleteById(id);
        }
    }
}
