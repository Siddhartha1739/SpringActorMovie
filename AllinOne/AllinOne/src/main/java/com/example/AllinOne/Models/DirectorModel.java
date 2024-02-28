package com.example.AllinOne.Models;

import com.example.AllinOne.Entity.Movie;
import jakarta.persistence.OneToOne;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DirectorModel {
    private Long DirectorId;
    private String DirectorName;
    private Movie movie;
}
