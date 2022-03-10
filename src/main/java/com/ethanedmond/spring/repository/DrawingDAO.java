package com.ethanedmond.spring.repository;

import com.ethanedmond.spring.model.Artist;
import com.ethanedmond.spring.model.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DrawingDAO extends JpaRepository<Drawing, Integer> {

    public Drawing save(Drawing drawing);

    @Query("SELECT d FROM Drawing d WHERE d.study.studyId = :studyId")
    public List<Drawing> getByStudyId(int studyId);

    @Query("SELECT d FROM Drawing d WHERE d.artist.artistId = :artistId")
    public List<Drawing> getByArtistId(int artistId);
//    public List<Drawing> findByArtistID(int artistId);
//
//    public List<Drawing> findByStudyId(int studyId);
}
