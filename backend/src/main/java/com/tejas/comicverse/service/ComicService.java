package com.tejas.comicverse.service;

import com.tejas.comicverse.dto.ComicRequest;
import com.tejas.comicverse.entity.Comic;

import java.util.List;

public interface ComicService {
    Comic createComic(ComicRequest request);
    List<Comic> getAllComics();
    Comic getComicById(Long id);
    Comic updateComic(Long id, ComicRequest request);
    void deleteComic(Long id);
}
