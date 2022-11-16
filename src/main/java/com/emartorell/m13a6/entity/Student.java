package com.emartorell.m13a6.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean wantsNewsLetter;
    @ManyToMany
    @JoinTable(
            name = "JOINED_COURSES",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<Course> joinedCourses;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isWantsNewsLetter() {
        return wantsNewsLetter;
    }

    public void setWantsNewsLetter(boolean wantsNewsLetter) {
        this.wantsNewsLetter = wantsNewsLetter;
    }

    public List<Course> getJoinedCourses() {
        return joinedCourses;
    }

    public void setJoinedCourses(List<Course> joinedCourses) {
        this.joinedCourses = joinedCourses;
    }
}
