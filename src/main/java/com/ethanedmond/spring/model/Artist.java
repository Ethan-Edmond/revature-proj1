package com.ethanedmond.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private int artistId;

    @Column(unique = true, nullable = false)
    private String username;

    @OneToMany
    @JoinColumn(name = "artistId")
    private List<Study> studies;

    @OneToMany
    @JoinColumn(name = "artistId")
    private List<Drawing> drawings;

    public int getArtistId() {
        return artistId;
    }

    public String getUsername() {
        return username;
    }

    public List<Study> getStudies() {
        return studies;
    }

    public List<Drawing> getDrawings() {
        return drawings;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStudies(List<Study> studies) {
        this.studies = studies;
    }

    public void setDrawings(List<Drawing> drawings) {
        this.drawings = drawings;
    }
}
