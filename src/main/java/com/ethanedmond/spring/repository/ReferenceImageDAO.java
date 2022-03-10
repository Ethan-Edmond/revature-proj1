package com.ethanedmond.spring.repository;

import com.ethanedmond.spring.model.ReferenceImage;
import com.ethanedmond.spring.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ReferenceImageDAO extends JpaRepository<ReferenceImage, Integer> {

    public ReferenceImage save(ReferenceImage referenceImage);
// TODO remove after testing!
//    @Query("SELECT a FROM Study a WHERE a.owner.artistId = :artistId")
//    public List<Study> getByArtistId(Integer artistId);

    @Query("SELECT r FROM ReferenceImage r WHERE r.study.studyId = :studyId")
    public List<ReferenceImage> getByStudyId(int studyId);
}
