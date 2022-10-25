package com.cydeo.entity;


import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Movie extends BaseEntity {

// id will come from base entity
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    we don't need constructor because we will initialise the data with sql code

    private Integer duration;

    private String name;

    private BigDecimal price;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(columnDefinition = "text")
    private String summary;

    @Enumerated(EnumType.STRING)
    private Type type;

    // movie_genre_rel (movie_id, genre_id)
    @ManyToMany
    @JoinTable(name = "movie_genre_rel",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;

}
