package com.example.AllinOne.Service;

import com.example.AllinOne.Entity.Actor;
import com.example.AllinOne.Entity.Director;
import com.example.AllinOne.Entity.Movie;
import com.example.AllinOne.Entity.MovieCast;
import com.example.AllinOne.Models.ActorModel;
import com.example.AllinOne.Models.DirectorModel;
import com.example.AllinOne.Models.MovieCastModel;
import com.example.AllinOne.Models.MovieModel;
import com.example.AllinOne.Repository.ActorRepository;
import com.example.AllinOne.Repository.DirectorRepository;
import com.example.AllinOne.Repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private DirectorRepository directorRepository;
    public void addMovie(MovieModel movieModel, DirectorModel directorModel,MovieCastModel movieCastModel) {
        Director director=MovieService.ModelToEntityDirector(directorModel);
        Movie movie= MovieService.ModelToEntityMovie(movieModel);
        MovieCast movieCast=MovieService.ModelToEntityMovieCast(movieCastModel);

        director.setActorMovies(movie);
        movie.setMovieCast(movieCast);
        movie.setMovieDirector(director);

        movieRepository.save(movie);
    }


    public List<MovieModel> viewMovies() {
        List<Movie> movieList= (List<Movie>) movieRepository.findAll();
        List<MovieModel> movieModelList=new ArrayList<>();

        movieList.forEach(movie -> {
            MovieModel movieModel=MovieService.EntityToModelMovie(movie);
            MovieCastModel movieCastModel=MovieService.EntityToModelMovieCast(movie.getMovieCast());
            movieModel.setMovieCastModel(movieCastModel);
            movieModelList.add(movieModel);
        });
        return movieModelList;
    }
    public List<DirectorModel> viewDirector() {
        List<Director> directorList= directorRepository.findAll();
        List<DirectorModel> directorModelList=new ArrayList<>();

        directorList.forEach(director -> {
            DirectorModel directorModel=MovieService.EntityToModelDirector(director);
            directorModelList.add(directorModel);
        });
        return directorModelList;
    }

    public void addActor(ActorModel actorModel) {
        Actor actor=MovieService.ModelToEntityActor(actorModel);
        actorRepository.save(actor);
    }
    public List<ActorModel> viewActors() {
        List<Actor> actorList= (List<Actor>) actorRepository.findAll();
        List<ActorModel> actorModelList=new ArrayList<>();

        actorList.forEach(actor -> {
            ActorModel actorModel=MovieService.EntityToModelActor(actor);
            actorModelList.add(actorModel);
        });
        return actorModelList;
    }

    public void delActor(int ActorId) {
        Actor actor=actorRepository.getReferenceById(ActorId);
        List<Movie> movieList=actor.getMovies();

        for(Movie movie: movieList){
            List<Actor> actorList=movie.getActors();
            if(actorList.contains(actor)){
                actorList.remove(actor);
                movie.setActors(actorList);
                movieRepository.save(movie);
            }
        }
        actor.setMovies(new ArrayList<>());
        actorRepository.delete(actor);
    }

    public void delMovie(int MovieId) {
        Movie movie=movieRepository.getReferenceById(MovieId);
        List<Actor> actorList=movie.getActors();

        for(Actor actor: actorList){
            List<Movie> movieList=actor.getMovies();
            if(movieList.contains(movie)){
                movieList.remove(movie);
                actor.setMovies(movieList);
                actorRepository.save(actor);
            }
        }
        movie.setActors(new ArrayList<>());
        movieRepository.delete(movie);
    }

    public void assignMovies(int ActorId,int MovieId){
        Actor actor=actorRepository.getReferenceById(ActorId);
        Movie movie=movieRepository.getReferenceById(MovieId);

        List<Actor> actorList=movie.getActors();
        List<Movie> movieList=actor.getMovies();

        actorList.add(actor);
        movieList.add(movie);

        actor.setMovies(movieList);
        movie.setActors(actorList);

        actorRepository.save(actor);
        movieRepository.save(movie);
    }

    public void removeActorMovie(int ActorId, int MovieId) {
        Actor actor=actorRepository.getReferenceById(ActorId);
        Movie movie=movieRepository.getReferenceById(MovieId);

        List<Movie> movieList= actor.getMovies();
        List<Actor> actorList=movie.getActors();

        movieList.remove(movie);
        actorList.remove(actor);

        actor.setMovies(movieList);
        movie.setActors(actorList);

        actorRepository.save(actor);
        movieRepository.save(movie);
    }

    public List<MovieModel> getMoviesByActor(int ActorId){
        Actor actor=actorRepository.getReferenceById(ActorId);
        List<Movie> movieList=actor.getMovies();
        List<MovieModel> movieModelList=new ArrayList<>();
        movieList.forEach(movie -> {
            MovieModel movieModel=MovieService.EntityToModelMovie(movie);
            MovieCastModel movieCastModel=MovieService.EntityToModelMovieCast(movie.getMovieCast());
            movieModel.setMovieCastModel(movieCastModel);
            movieModelList.add(movieModel);
        });
        return movieModelList;
    }
    public List<ActorModel> getActorsByMovie(int MovieId){
        Movie movie=movieRepository.getReferenceById(MovieId);
        List<Actor> actorList=movie.getActors();
        List<ActorModel> actorModelList=new ArrayList<>();
        actorList.forEach(actor -> {
            ActorModel actorModel=MovieService.EntityToModelActor(actor);
            actorModelList.add(actorModel);
        });
        return actorModelList;
    }

    public MovieModel getMoviesByDirector(int DirectorId){
        Director director=directorRepository.getReferenceById(DirectorId);
        Movie movie=director.getActorMovies();
        MovieModel movieModel=MovieService.EntityToModelMovie(movie);
        MovieCastModel movieCastModel=MovieService.EntityToModelMovieCast(movie.getMovieCast());
        movieModel.setMovieCastModel(movieCastModel);
        return movieModel;
    }

    public Actor getActorById(int ActorId) {
        return actorRepository.getReferenceById(ActorId);
    }


    public static Movie ModelToEntityMovie(MovieModel movieModel){
        Movie movie=new Movie();
        BeanUtils.copyProperties(movieModel,movie);
        return movie;
    }
    public static MovieModel EntityToModelMovie(Movie movie){
        MovieModel movieModel=new MovieModel();
        BeanUtils.copyProperties(movie,movieModel);
        return movieModel;
    }
    public static Actor ModelToEntityActor(ActorModel actorModel){
        Actor actor=new Actor();
        BeanUtils.copyProperties(actorModel,actor);
        return actor;
    }
    public static ActorModel EntityToModelActor(Actor actor){
        ActorModel actorModel=new ActorModel();
        BeanUtils.copyProperties(actor,actorModel);
        return actorModel;
    }

    public static Director ModelToEntityDirector(DirectorModel directorModel){
        Director director=new Director();
        BeanUtils.copyProperties(directorModel,director);
        return director;
    }
    public static DirectorModel EntityToModelDirector(Director director){
        DirectorModel directorModel=new DirectorModel();
        BeanUtils.copyProperties(director,directorModel);
        return directorModel;
    }
    public static MovieCast ModelToEntityMovieCast(MovieCastModel movieCastModel){
        MovieCast movieCast=new MovieCast();
        BeanUtils.copyProperties(movieCastModel,movieCast);
        return movieCast;
    }
    public static MovieCastModel EntityToModelMovieCast(MovieCast movieCast){
        MovieCastModel movieCastModel=new MovieCastModel();
        BeanUtils.copyProperties(movieCast,movieCastModel);
        return movieCastModel;
    }
}
