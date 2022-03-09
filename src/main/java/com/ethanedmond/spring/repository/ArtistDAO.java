package com.ethanedmond.spring.repository;

import com.ethanedmond.spring.model.Artist;
import com.ethanedmond.spring.model.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ArtistDAO extends JpaRepository<Artist, Integer> {

    public Artist save(Artist artist);

    public List<Artist> findAll();

    public Artist findByUsername(String username);

    public Artist findByArtistId(Integer artistId);

//    @Query("FROM drawing ")
//    public List<Drawing> findAllDrawings(Artist artist);
}
