package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Genre extends BaseEntity{

    private String name;

//    @ManyToMany(mappedBy = "genreList")
//    private List<Movie> movieList;
}
