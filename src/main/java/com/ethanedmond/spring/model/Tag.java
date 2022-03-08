package com.ethanedmond.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private int tagId;

    @ManyToMany(targetEntity = Study.class)
    private List<Study> studies;

    @Column
    private String name;
}
