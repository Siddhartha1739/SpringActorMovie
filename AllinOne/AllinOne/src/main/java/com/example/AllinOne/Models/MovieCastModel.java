package com.example.AllinOne.Models;

import com.example.AllinOne.Entity.Movie;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieCastModel {
    private Long castId;
    private List<String> CastNames=new ArrayList<>();
    private String Producer;
    private String MusicDirector;
    private Long MovieBudget;
}
