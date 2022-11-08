package com.emartorell.m13a6.controller;

import com.emartorell.m13a6.entity.Course;
import com.emartorell.m13a6.entity.CourseMaterial;
import com.emartorell.m13a6.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("m13a6")
public class CourseMaterialController {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @GetMapping("materials")
    public Iterable<CourseMaterial> getAllCourseMaterial(){
        return courseMaterialRepository.findAll();
    }

    @GetMapping ("material/{id}")
    public CourseMaterial getById(@PathVariable long id){
        return courseMaterialRepository.findById(id).orElse(null);
    }

    @GetMapping("course/{course}/materials")
    public Iterable<CourseMaterial> getCourseMaterials(@PathVariable Course course){
        return courseMaterialRepository.getAllByCourse(course);
    }
}
