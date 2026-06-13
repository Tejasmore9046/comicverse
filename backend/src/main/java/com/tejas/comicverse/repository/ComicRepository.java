package com.tejas.comicverse.repository;

import com.tejas.comicverse.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic, Long> {
}
