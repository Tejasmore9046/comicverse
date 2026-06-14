package com.tejas.comicverse.controller;

import com.tejas.comicverse.dto.ChapterRequest;
import com.tejas.comicverse.entity.Chapter;
import com.tejas.comicverse.repository.ChapterRepository;
import com.tejas.comicverse.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;
    private final ChapterRepository chapterRepository;

    @PostMapping
    public Chapter createChapter(@RequestBody ChapterRequest request) {
        return chapterService.createChapter(request);
    }

    @GetMapping("/comic/{comicId}")
    public List<Chapter> getChaptersByComic(
            @PathVariable Long comicId) {

        return chapterRepository.findByComicId(comicId);
    }

    @GetMapping("/{id}")
    public Chapter getChapter(@PathVariable Long id) {

        return chapterRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Chapter not found"));
    }
    @DeleteMapping("/{id}")
    public String deleteChapter(@PathVariable Long id) {

        chapterRepository.deleteById(id);

        return "Chapter deleted";
    }

    @PutMapping("/{id}")
    public Chapter updateChapter(
            @PathVariable Long id,
            @RequestBody ChapterRequest request) {

        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Chapter not found"));

        chapter.setTitle(request.getTitle());
        chapter.setChapterNumber(request.getChapterNumber());
        chapter.setContent(request.getContent());

        return chapterRepository.save(chapter);
    }


}