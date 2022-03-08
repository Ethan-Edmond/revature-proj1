package com.ethanedmond.spring.service;

import com.ethanedmond.spring.model.Artist;
import com.ethanedmond.spring.repository.ArtistDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistService {
    ArtistDAO dao;

    @Autowired
    public ArtistService(ArtistDAO dao) {
        this.dao = dao;
    }

    public Artist save(Artist user) {
        return dao.save(user);
    }

    public List<Artist> findAll() {
        return dao.findAll();
    }

    public Artist findByUsername(String username) { return dao.findByUsername(username); }
}
