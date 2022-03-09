package com.ethanedmond.spring.stubs;

import com.ethanedmond.spring.model.Study;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudyStub {
    private int studyId; // TODO change all Integers to ints or vice versa, just choose one
    private int artistId;
    private String title;
    private int totalDifficulty;
    private int difficultyVotes;

    public StudyStub() {}

    public StudyStub(Study toStub) {
        this.studyId = toStub.getStudyId();
        this.artistId = toStub.getOwner().getArtistId();
        this.title = toStub.getTitle();
        this.totalDifficulty = toStub.getTotalDifficulty();
        this.difficultyVotes = toStub.getDifficultyVotes();
    }

    public StudyStub(int studyId, int artistId, String title, int totalDifficulty, int difficultyVotes) {
        this.studyId = studyId;
        this.artistId = artistId;
        this.title = title;
        this.totalDifficulty = totalDifficulty;
        this.difficultyVotes = difficultyVotes;
    }

    public int getStudyId() {
        return studyId;
    }

    public void setStudyId(int studyId) {
        this.studyId = studyId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
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

    public String difficultyString() {
        if (this.difficultyVotes == 0) {
            return "0/5";
        } else {
            return (this.totalDifficulty / this.difficultyVotes) + "/5";
        }
    }
}
