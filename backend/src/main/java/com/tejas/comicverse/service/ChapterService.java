package com.tejas.comicverse.service;

import com.tejas.comicverse.dto.ChapterRequest;
import com.tejas.comicverse.entity.Chapter;

public interface ChapterService {

    Chapter createChapter(ChapterRequest request);
}