package com.ethanedmond.spring.model;

import javax.persistence.*;

@Entity
public class Drawing {
    @Id
    @GeneratedValue
    private int drawingId;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "studyId")
    private Study study;

    @Column
    private String imageLink;
}
