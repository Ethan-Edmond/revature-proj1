package com.ethanedmond.spring.stubs;

import com.ethanedmond.spring.model.Study;

public class StudiesStub {
    private int studyId;
    private String title;
    private int totalDifficulty;
    private int difficultyVotes;

    public StudiesStub(Study toStub) {
        this.studyId = toStub.getStudyId();
        this.title = toStub.getTitle();
        this.totalDifficulty = toStub.getTotalDifficulty();
        this.difficultyVotes = toStub.getDifficultyVotes();
    }

    public int getStudyId() {
        return studyId;
    }

    public void setStudyId(int studyId) {
        this.studyId = studyId;
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
