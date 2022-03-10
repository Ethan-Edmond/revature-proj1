package com.ethanedmond.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Study {
    @Id
    @GeneratedValue
    private int studyId;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private Artist owner;

    @OneToMany
    @JoinColumn(name = "studyId")
    private List<Drawing> drawings;

    @OneToMany
    @JoinColumn(name = "studyId")
    private List<ReferenceImage> referenceImages;

    @Column
    private String title;

    @Column
    private int totalDifficulty;

    @Column
    private int difficultyVotes;

    public int getStudyId() {
        return studyId;
    }

    public void setStudyId(int studyId) {
        this.studyId = studyId;
    }

    public Artist getOwner() {
        return owner;
    }

    public void setOwner(Artist owner) {
        this.owner = owner;
    }

    public List<Drawing> getDrawings() {
        return drawings;
    }

    public void setDrawings(List<Drawing> drawings) {
        this.drawings = drawings;
    }

    public List<ReferenceImage> getReferenceImages() {
        return referenceImages;
    }

    public void setReferenceImages(List<ReferenceImage> referenceImages) {
        this.referenceImages = referenceImages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalDifficulty() {
        return totalDifficulty;
    }

    public void setTotalDifficulty(int totalDifficulty) {
        this.totalDifficulty = totalDifficulty;
    }

    public int getDifficultyVotes() {
        return difficultyVotes;
    }

    public void setDifficultyVotes(int difficultyVotes) {
        this.difficultyVotes = difficultyVotes;
    }

    public void addDifficulty(int difficultyRating) {
        this.totalDifficulty += difficultyRating;
        this.difficultyVotes++;
    }
}
