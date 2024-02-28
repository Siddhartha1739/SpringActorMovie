package com.example.AllinOne.Models;

import com.example.AllinOne.Entity.Movie;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActorModel {
    private Long ActorId;
    private String ActorName;
    private List<Movie> ActorMovies = new ArrayList<>();
}
