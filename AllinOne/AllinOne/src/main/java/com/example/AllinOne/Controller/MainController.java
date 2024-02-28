package com.example.AllinOne.Controller;

import com.example.AllinOne.Entity.Actor;
import com.example.AllinOne.Entity.Director;
import com.example.AllinOne.Entity.Movie;
import com.example.AllinOne.Models.ActorModel;
import com.example.AllinOne.Models.DirectorModel;
import com.example.AllinOne.Models.MovieCastModel;
import com.example.AllinOne.Models.MovieModel;
import com.example.AllinOne.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/first")
    public String first(){
        return "first";
    }

    @RequestMapping("/addMovie")
    public String addMovie(){
        return "addMovie";
    }

    @RequestMapping("/addedMovies")
    public String  addedMovies(MovieModel movieModel, ModelMap model, DirectorModel directorModel,MovieCastModel movieCastModel){
        movieService.addMovie(movieModel,directorModel,movieCastModel);
        List<MovieModel> movieList=movieService.viewMovies();
        model.addAttribute("movieList",movieList);
        return "viewMovie";
    }

    @RequestMapping("/viewMovie")
    public String viewMovie(ModelMap model){
        List<MovieModel> movieList=movieService.viewMovies();
        model.addAttribute("movieList",movieList);
        return "viewMovie";
    }
    @RequestMapping("/viewDirector")
    public String viewDirector(ModelMap model){
        List<DirectorModel> directorList=movieService.viewDirector();
        model.addAttribute("directorList",directorList);
        return "viewDirector";
    }

    @RequestMapping("/viewDirectorMovies")
    public String viewDirectorMovies(ModelMap model,int DirectorId){
        MovieModel movieModel=movieService.getMoviesByDirector(DirectorId);
        Long id=movieModel.getMovieId();
        String title=movieModel.getMovieTitle();
        model.put("id",id);
        model.put("title",title);
        model.addAttribute("movieModel",movieModel);
        return "viewDirectorMovies";
    }

    @RequestMapping("/addActor")
    public String addActor(){
        return "addActor";
    }

    @RequestMapping("/addedActor")
    public String  addedActor(ActorModel actorModel, ModelMap model){
        movieService.addActor(actorModel);
        System.out.println("Entered");
        Long ActorId=actorModel.getActorId();
        String ActorName=actorModel.getActorName();
        model.put("ActorId",ActorId);
        model.put("ActorName",ActorName);
        model.addAttribute("actorModel",actorModel);
        List<ActorModel> actorsList=movieService.viewActors();
        model.addAttribute("actorsList",actorsList);
        return "viewActor";
    }

    @RequestMapping("/viewActor")
    public String viewActor(ModelMap model){
        List<ActorModel> actorsList=movieService.viewActors();
        model.addAttribute("actorsList",actorsList);
        return "viewActor";
    }

    @RequestMapping("/assignMovies")
    public String assignMovies(ModelMap model,int ActorId){
        model.put("ActorId",ActorId);
        return "assignMovies";
    }

    @RequestMapping("/assignActors")
    public String assignActors(ModelMap model,int MovieId){
        model.put("MovieId",MovieId);
        return "assignActors";
    }


    @RequestMapping("/assignedMovies")
    public String assignedMovies(ModelMap model,int ActorId,int MovieId){
        movieService.assignMovies(ActorId,MovieId);
        List<MovieModel> movieModelList=movieService.getMoviesByActor(ActorId);
        model.addAttribute("movieModelList",movieModelList);
        model.put("ActorId",ActorId);
        return "viewMovieList";
    }

    @RequestMapping("/assignedActors")
    public String assignedActors(ModelMap model,int ActorId,int MovieId){
        movieService.assignMovies(ActorId,MovieId);
        List<ActorModel> actorModelList=movieService.getActorsByMovie(MovieId);
        model.addAttribute("actorModelList",actorModelList);
        model.put("MovieId",MovieId);
        return "viewActorList";
    }
    @RequestMapping("/RemoveActor")
    public String RemoveActor(int ActorId,int MovieId,ModelMap model){
        movieService.removeActorMovie(ActorId,MovieId);
        List<ActorModel> actorModelList=movieService.getActorsByMovie(MovieId);
        model.addAttribute("actorModelList",actorModelList);
        model.put("MovieId",MovieId);
        return"viewActorList";
    }

    @RequestMapping("/viewActorList")
    public String viewActorList(int MovieId,ModelMap model){
        List<ActorModel> actorModelList=movieService.getActorsByMovie(MovieId);
        model.addAttribute("actorModelList",actorModelList);
        model.put("MovieId",MovieId);
        return"viewActorList";
    }

    @RequestMapping("/RemoveMovie")
    public String RemoveMovie(int ActorId,int MovieId,ModelMap model){
        movieService.removeActorMovie(ActorId,MovieId);
        List<MovieModel> movieModelList=movieService.getMoviesByActor(ActorId);
        model.addAttribute("movieModelList",movieModelList);
        model.put("ActorId",ActorId);
        return"viewMovieList";
    }

    @RequestMapping("/viewMovieList")
    public String viewMovieList(int ActorId,ModelMap model){
        List<MovieModel> movieModelList=movieService.getMoviesByActor(ActorId);
        model.addAttribute("movieModelList",movieModelList);
        model.put("ActorId",ActorId);
        return"viewMovieList";
    }

    @RequestMapping("/deleteActor")
    public String deleteActor(ModelMap model,int ActorId){
        movieService.delActor(ActorId);
        List<ActorModel> actorsList=movieService.viewActors();
        model.addAttribute("actorsList",actorsList);
        return "viewActor";
    }

    @RequestMapping("/deleteMovie")
    public String deleteMovie(ModelMap model,int MovieId){
        movieService.delMovie(MovieId);
        List<MovieModel> movieList=movieService.viewMovies();
        model.addAttribute("movieList",movieList);
        return "viewMovie";
    }


}
