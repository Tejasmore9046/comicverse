package com.tejas.comicverse.dto;

import lombok.Data;

@Data
public class ComicRequest {
    private String title;
    private String description;
    private String author;
    private String coverImageUrl;
    private String genre;
}
