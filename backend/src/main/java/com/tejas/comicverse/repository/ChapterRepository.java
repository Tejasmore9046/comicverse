package com.tejas.comicverse.repository;

import com.tejas.comicverse.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    List<Chapter> findByComicId(Long comicId);
}