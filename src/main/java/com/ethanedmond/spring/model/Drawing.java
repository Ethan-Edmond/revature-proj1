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

    public Drawing() { }

    public int getDrawingId() {
        return drawingId;
    }

    public void setDrawingId(int drawingId) {
        this.drawingId = drawingId;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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
