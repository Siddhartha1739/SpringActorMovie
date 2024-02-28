package com.example.AllinOne.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MovieId;
    private String MovieTitle;
    @Embedded
    private MovieCast movieCast;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Director MovieDirector;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Actor", joinColumns = @JoinColumn(name = "MovieId"),
            inverseJoinColumns = @JoinColumn(name = "ActorId"))
    private List<Actor> actors = new ArrayList<>();

    public Movie() {
    }

    public Movie(Long movieId, String movieTitle,MovieCast moviecast,  Director movieDirector, List<Actor> actors) {
        MovieId = movieId;
        movieCast=moviecast;
        MovieTitle = movieTitle;
        MovieDirector = movieDirector;
        this.actors = actors;
    }

    public Long getMovieId() {
        return MovieId;
    }

    public void setMovieId(Long movieId) {
        MovieId = movieId;
    }

    public String getMovieTitle() {
        return MovieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        MovieTitle = movieTitle;
    }

    public Director getMovieDirector() {
        return MovieDirector;
    }

    public void setMovieDirector(Director movieDirector) {
        MovieDirector = movieDirector;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public MovieCast getMovieCast() {
        return movieCast;
    }

    public void setMovieCast(MovieCast movieCast) {
        this.movieCast = movieCast;
    }
}
