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

    public Artist save(Artist artist) {
        return this.dao.save(artist);
    }

    public List<Artist> findAll() {
        return this.dao.findAll();
    }

    public Artist findByUsername(String username) { return this.dao.findByUsername(username); }

    public Artist findByArtistId(Integer artistId) {
        return this.dao.findByArtistId(artistId);
    }
}
