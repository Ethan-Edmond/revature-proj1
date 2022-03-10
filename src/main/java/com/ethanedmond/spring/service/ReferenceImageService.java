package com.ethanedmond.spring.service;

import com.ethanedmond.spring.model.ReferenceImage;
import com.ethanedmond.spring.repository.ReferenceImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReferenceImageService {
    ReferenceImageDAO dao;

    @Autowired
    public ReferenceImageService(ReferenceImageDAO dao) {
        this.dao = dao;
    }

    public ReferenceImage save(ReferenceImage referenceImage) {
        return this.dao.save(referenceImage);
    }

    public List<ReferenceImage> getByStudyId(int studyId) {
        return this.dao.getByStudyId(studyId);
    }
}
