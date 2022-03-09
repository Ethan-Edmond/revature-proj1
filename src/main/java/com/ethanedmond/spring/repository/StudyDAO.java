package com.ethanedmond.spring.repository;

import com.ethanedmond.spring.model.Artist;
import com.ethanedmond.spring.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StudyDAO extends JpaRepository<Study, Integer> {

    public List<Study> findAll();

    @Query("SELECT a FROM Study a WHERE a.owner.artistId = :artistId")
    public List<Study> getByArtistId(Integer artistId);

    public Study findByStudyId(Integer studyId);

    public Study save(Study study);
}
