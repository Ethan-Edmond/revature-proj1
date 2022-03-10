package com.ethanedmond.spring.service;

import com.ethanedmond.spring.model.Drawing;
import com.ethanedmond.spring.repository.DrawingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrawingService {
    DrawingDAO dao;

    @Autowired
    public DrawingService(DrawingDAO dao) {
        this.dao = dao;
    }

    public Drawing save(Drawing drawing) {
        return this.dao.save(drawing); // TODO Fix this!!!
    }

    public List<Drawing> getByStudyId(int studyId) {
        return this.dao.getByStudyId(studyId);
    }

    public List<Drawing> getByArtistId(int artistId) {
        return this.dao.getByArtistId(artistId);
    }
}
