package com.example.AllinOne.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Director {
     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DirectorId;
    private String DirectorName;
    @OneToOne(cascade = CascadeType.ALL)
    private Movie ActorMovies;

    public Director() {
    }

    public Director(Long directorId, String directorName, Movie actorMovies) {
        DirectorId = directorId;
        DirectorName = directorName;
        ActorMovies = actorMovies;
    }

    public Long getDirectorId() {
        return DirectorId;
    }

    public void setDirectorId(Long directorId) {
        DirectorId = directorId;
    }

    public String getDirectorName() {
        return DirectorName;
    }

    public void setDirectorName(String directorName) {
        DirectorName = directorName;
    }

    public Movie getActorMovies() {
        return ActorMovies;
    }

    public void setActorMovies(Movie actorMovies) {
        ActorMovies = actorMovies;
    }
}
