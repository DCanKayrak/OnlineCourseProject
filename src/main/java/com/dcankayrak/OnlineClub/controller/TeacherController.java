package com.dcankayrak.OnlineClub.controller;

import com.dcankayrak.OnlineClub.dto.StudentCreateRequest;
import com.dcankayrak.OnlineClub.dto.TeacherCreateRequest;
import com.dcankayrak.OnlineClub.model.Student;
import com.dcankayrak.OnlineClub.model.Teacher;
import com.dcankayrak.OnlineClub.repository.TeacherRepository;
import com.dcankayrak.OnlineClub.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        return ResponseEntity.ok(this.teacherService.getAllTeachers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id){
        return ResponseEntity.ok(this.teacherService.getTeacher(id));
    }

    @PostMapping
    public ResponseEntity<Teacher> createStudent(@RequestBody TeacherCreateRequest request){
        return ResponseEntity.ok(this.teacherService.createTeacher(request));
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id){
        this.teacherService.deleteTeacher(id);
    }
}
