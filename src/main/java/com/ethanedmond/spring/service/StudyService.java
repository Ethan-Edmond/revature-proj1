package com.ethanedmond.spring.service;

import com.ethanedmond.spring.model.Study;
import com.ethanedmond.spring.repository.StudyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StudyService {
    StudyDAO dao;

    @Autowired
    public StudyService(StudyDAO dao) {
        this.dao = dao;
    }

    public Study save(Study study) {
        return this.dao.save(study);
    }

    public List<Study> getByArtistId(Integer artistId) {
        return this.dao.getByArtistId(artistId);
    };

    public List<Study> findAll() {
        return this.dao.findAll();
    }

    public Study findByStudyId(Integer studyId) {
        return this.dao.findByStudyId(studyId);
    }
}
