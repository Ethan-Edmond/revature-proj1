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
}
