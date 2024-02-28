package com.example.AllinOne.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity

public class Actor {
    @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ActorId;
    private String ActorName;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Actor", joinColumns = @JoinColumn(name = "ActorId"),
            inverseJoinColumns = @JoinColumn(name = "MovieId"))
    private List<Movie> movies = new ArrayList<>();

    public Actor() {
    }

    public Actor(Long actorId, String actorName, List<Movie> movies) {
        ActorId = actorId;
        ActorName = actorName;
        this.movies = movies;
    }

    public Long getActorId() {
        return ActorId;
    }

    public void setActorId(Long actorId) {
        ActorId = actorId;
    }

    public String getActorName() {
        return ActorName;
    }

    public void setActorName(String actorName) {
        ActorName = actorName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
