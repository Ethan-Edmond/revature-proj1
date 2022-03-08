package com.ethanedmond.spring.repository;

import com.ethanedmond.spring.model.Artist;
import com.ethanedmond.spring.model.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DrawingDAO extends JpaRepository<Drawing, Integer> {

    public Drawing save(Drawing drawing);

//    public List<Drawing> findByArtistID(int artistId);
//
//    public List<Drawing> findByStudyId(int studyId);
}
