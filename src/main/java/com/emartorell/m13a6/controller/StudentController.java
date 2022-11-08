package com.emartorell.m13a6.controller;

import com.emartorell.m13a6.entity.Student;
import com.emartorell.m13a6.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("m13a6")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("students")
    public Iterable<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("students/{id}")
    public Student getStudent(@PathVariable long id){
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping("addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("setStudent/{id}")
    public Student setStudent(@PathVariable long id, @RequestBody Student student){
        if (studentRepository.existsById(id)){
            student.setId(id);
            return studentRepository.save(student);
        } else {
            // return studentRepository.save(student);
            return null;
        }
    }

    @DeleteMapping("delStudent/{id}")
    public Student delStudent(@PathVariable long id){
        if (studentRepository.existsById(id)) {
            Student student = studentRepository.findById(id).orElse(null);
            studentRepository.deleteById(id);
            return student;
        } else {
            return null;
        }
    }
}
