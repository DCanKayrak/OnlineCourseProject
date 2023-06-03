package com.dcankayrak.OnlineClub.service;

import com.dcankayrak.OnlineClub.dto.CourseSaveRequest;
import com.dcankayrak.OnlineClub.dto.CourseUpdateRequest;
import com.dcankayrak.OnlineClub.model.Course;
import com.dcankayrak.OnlineClub.model.Teacher;
import com.dcankayrak.OnlineClub.repository.CourseRepository;
import com.dcankayrak.OnlineClub.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    @Transactional
    public List<Course> getAllCourses(){
        return this.courseRepository.findAll();
    }

    @Transactional
    public Course saveCourse(CourseSaveRequest request){
        final Teacher tempTeacher = this.teacherRepository.findById(request.getTeacherId()).orElse(null);

        final Course course = Course
                .builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .teacher(tempTeacher)
                .build();

        return courseRepository.save(course);
    }

    @Transactional
    public Course updateCourse(Long courseId, CourseUpdateRequest request){
        final Course tempCourse = this.courseRepository.findById(courseId).orElseThrow();

        tempCourse.setDescription(request.getDescription());
        tempCourse.setTitle(request.getTitle());

        return this.courseRepository.save(tempCourse);
    }

    @Transactional
    public void deleteCourse(Long courseId){
        final Course tempCourse = this.courseRepository.findById(courseId).orElseThrow();
        if(tempCourse != null) {
            this.courseRepository.delete(tempCourse);
        }
    }

}
