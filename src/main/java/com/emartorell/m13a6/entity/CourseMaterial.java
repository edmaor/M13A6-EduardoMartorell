package com.emartorell.m13a6.entity;

import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class CourseMaterial {

    @Id
    private long id;
    @OneToOne
    private Course course;
    String url;

}
