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

    public int getReferenceImageId() {
        return referenceImageId;
    }

    public void setReferenceImageId(int referenceImageId) {
        this.referenceImageId = referenceImageId;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
