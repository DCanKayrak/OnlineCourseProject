package com.dcankayrak.OnlineClub.service;

import com.dcankayrak.OnlineClub.dto.TeacherCreateRequest;
import com.dcankayrak.OnlineClub.model.Teacher;
import com.dcankayrak.OnlineClub.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.findAll();
    }

    public Teacher getTeacher(Long id) {
        return this.teacherRepository.findById(id).orElseThrow();
    }

    public Teacher createTeacher(TeacherCreateRequest request) {
        Teacher newTeacher = Teacher
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .build();
        return this.teacherRepository.save(newTeacher);
    }

    public void deleteTeacher(Long id) {
        this.teacherRepository.delete(this.teacherRepository.findById(id).orElseThrow());
    }
}
