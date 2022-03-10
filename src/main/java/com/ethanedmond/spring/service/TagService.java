package com.ethanedmond.spring.service;

import com.ethanedmond.spring.model.Study;
import com.ethanedmond.spring.model.Tag;
import com.ethanedmond.spring.repository.TagDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagService {
    @Autowired
    private TagDAO dao;

    public TagService(TagDAO dao) {
        this.dao = dao;
    }

    public Tag save(Tag tag) {
        return this.dao.save(tag);
    }

    public Tag findByName(String name) {
        return this.dao.findByName(name);
    }

    public List<Tag> getByStudyId(int studyId) {
        return this.dao.getByStudyId(studyId);
    }
}
