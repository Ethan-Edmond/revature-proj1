package com.ethanedmond.spring.model;

import javax.persistence.*;

@Entity
public class ReferenceImage {
    @Id
    @GeneratedValue
    private int referenceImageId;

    @ManyToOne
    @JoinColumn(name = "studyId")
    private Study study;

    @Column
    private String imageLink;
}
