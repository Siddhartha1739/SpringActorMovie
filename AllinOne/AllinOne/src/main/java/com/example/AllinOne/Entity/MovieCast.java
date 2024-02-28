package com.example.AllinOne.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class MovieCast {
    private Long castId;

    private String Producer;
    private String MusicDirector;

    private Long MovieBudget;

    public MovieCast() {
    }

    public MovieCast(Long castId, String producer, String musicDirector, Long movieBudget) {
        this.castId = castId;

        Producer = producer;
        MusicDirector = musicDirector;
        MovieBudget = movieBudget;
    }

    public Long getCastId() {
        return castId;
    }

    public void setCastId(Long castId) {
        this.castId = castId;
    }



    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public String getMusicDirector() {
        return MusicDirector;
    }

    public void setMusicDirector(String musicDirector) {
        MusicDirector = musicDirector;
    }

    public long getMovieBudget() {
        return MovieBudget;
    }

    public void setMovieBudget(Long movieBudget) {
        MovieBudget = movieBudget;
    }
}
