package com.tejas.comicverse.controller;

import com.tejas.comicverse.dto.ComicRequest;
import com.tejas.comicverse.entity.Comic;
import com.tejas.comicverse.repository.ComicRepository;
import com.tejas.comicverse.service.ComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comics")
@RequiredArgsConstructor
public class ComicController {
    private final ComicService comicService;

    @PostMapping
    public Comic createComic(@RequestBody ComicRequest request){
        return comicService.createComic(request);
    }

    @GetMapping
    public List<Comic> getAllComics() {
        return comicService.getAllComics();
    }

    @GetMapping("/{id}")
    public Comic getComicById(@PathVariable Long id){
        return comicService.getComicById(id);
    }

    @PutMapping("/{id}")
    public Comic updateComic(
            @PathVariable Long id,
            @RequestBody ComicRequest request) {

        return comicService.updateComic(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteComic(@PathVariable Long id) {

        comicService.deleteComic(id);

        return "Comic deleted successfully";
    }
}
