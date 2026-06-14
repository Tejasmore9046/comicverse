package com.tejas.comicverse.service.impl;

import com.tejas.comicverse.dto.ChapterRequest;
import com.tejas.comicverse.entity.Chapter;
import com.tejas.comicverse.entity.Comic;
import com.tejas.comicverse.repository.ChapterRepository;
import com.tejas.comicverse.repository.ComicRepository;
import com.tejas.comicverse.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;
    private final ComicRepository comicRepository;

    @Override
    public Chapter createChapter(ChapterRequest request) {

        Comic comic = comicRepository.findById(request.getComicId())
                .orElseThrow(() -> new RuntimeException("Comic not found"));

        Chapter chapter = Chapter.builder()
                .title(request.getTitle())
                .chapterNumber(request.getChapterNumber())
                .content(request.getContent())
                .comic(comic)
                .build();

        return chapterRepository.save(chapter);
    }
}