package com.tejas.comicverse.service.impl;

import com.tejas.comicverse.dto.ComicRequest;
import com.tejas.comicverse.entity.Comic;
import com.tejas.comicverse.repository.ComicRepository;
import com.tejas.comicverse.service.ComicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComicServiceImpl implements ComicService {
    private final ComicRepository comicRepository;

    @Override
    public void deleteComic(Long id) {

        Comic comic = comicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comic not found"));

        comicRepository.delete(comic);
    }

    @Override
    public Comic updateComic(Long id, ComicRequest request) {

        Comic comic = comicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comic not found"));

        comic.setTitle(request.getTitle());
        comic.setAuthor(request.getAuthor());
        comic.setGenre(request.getGenre());
        comic.setCoverImageUrl(request.getCoverImageUrl());
        comic.setDescription(request.getDescription());

        return comicRepository.save(comic);
    }

    @Override
    public Comic createComic (ComicRequest request){
        Comic comic = Comic.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .genre(request.getGenre())
                .coverImageUrl(request.getCoverImageUrl())
                .description(request.getDescription())
                .build();
        return comicRepository.save(comic);
    }

    @Override
    public List<Comic> getAllComics() {
        return comicRepository.findAll();
    }

    @Override
    public Comic getComicById(Long id){
        return comicRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Comic not found"));
    }
}
