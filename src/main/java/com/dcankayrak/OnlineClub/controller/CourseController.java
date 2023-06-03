package com.dcankayrak.OnlineClub.controller;

import com.dcankayrak.OnlineClub.dto.CourseSaveRequest;
import com.dcankayrak.OnlineClub.model.Course;
import com.dcankayrak.OnlineClub.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(this.courseService.getAllCourses());
    }

    @PostMapping
    public Course createCourse(@RequestBody CourseSaveRequest theRequest){
        return this.courseService.saveCourse(theRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        this.courseService.deleteCourse(id);
    }
}
