package com.ethanedmond.spring.repository;

import com.ethanedmond.spring.model.Study;
import com.ethanedmond.spring.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TagDAO extends JpaRepository<Tag, Integer> {
    public Tag save(Tag tag);

    public Tag findByName(String name);

    @Query(value = "SELECT t.* FROM tag t JOIN tag_study ts ON t.tag_id = ts.tag_tag_id WHERE ts.studies_study_id = :studyId",
            nativeQuery = true)
    public List<Tag> getByStudyId(int studyId);
}
