package com.tejas.comicverse.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String author;

    private String coverImageUrl;

    private String genre;
}
