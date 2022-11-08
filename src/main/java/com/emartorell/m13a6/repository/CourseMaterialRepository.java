package com.emartorell.m13a6.repository;

import com.emartorell.m13a6.entity.Course;
import com.emartorell.m13a6.entity.CourseMaterial;
import org.springframework.data.repository.CrudRepository;

public interface CourseMaterialRepository extends CrudRepository<CourseMaterial, Long> {
    public Iterable<CourseMaterial> getAllByCourse(Course course);
}
