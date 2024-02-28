package com.example.AllinOne.Models;

import com.example.AllinOne.Entity.Actor;
import com.example.AllinOne.Entity.Director;
import com.example.AllinOne.Entity.MovieCast;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieModel {
    private Long MovieId;
    private String MovieTitle;
    private Director MovieDirector;
   private MovieCastModel movieCastModel;
    private List<ActorModel> actorsModel = new ArrayList<>();
    
}
