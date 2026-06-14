package com.tejas.comicverse.dto;

import lombok.Data;

@Data
public class ChapterRequest {

    private String title;

    private Integer chapterNumber;

    private String content;

    private Long comicId;
}