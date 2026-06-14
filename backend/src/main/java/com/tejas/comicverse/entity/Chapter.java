package com.tejas.comicverse.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chapters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer chapterNumber;

    @Column(length = 10000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "comic_id")
    private Comic comic;
}