package com.emartorell.m13a6.controller;

import com.emartorell.m13a6.entity.Course;
import com.emartorell.m13a6.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/m13a6")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("courses")
    public Iterable<Course> getStudents(){
        return courseRepository.findAll();
    }

    @GetMapping("course/{id}")
    public Course getStudent(@PathVariable long id){
        return courseRepository.findById(id).orElse(null);
    }

    @PostMapping("addCourse")
    public Course addStudent(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @PutMapping("setCourse/{id}")
    public Course setStudent(@PathVariable long id, @RequestBody Course course){
        if (courseRepository.existsById(id)){
            course.setId(id);
            return courseRepository.save(course);
        } else {
            // return courseRepository.save(course);
            return null;
        }
    }

    @DeleteMapping("delCourse/{id}")
    public Course delCourse(@PathVariable long id){
        if (courseRepository.existsById(id)) {
            Course course = courseRepository.findById(id).orElse(null);
            courseRepository.deleteById(id);
            return course;
        } else {
            return null;
        }
    }
}
