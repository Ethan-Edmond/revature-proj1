package com.ethanedmond.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private int tagId;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Study.class)
    @JoinTable(name = "tag_study")
    private Set<Study> studies;

    @Column(unique = true, nullable = false)
    private String name;

    public Tag (String name) {
        this.name = name;
        this.studies = new HashSet<>();
    }

    public Tag () {}

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    public void addStudy(Study study) {
        this.studies.add(study);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
