package ee.jaltdorf.proovikontrolltoo1.controller;

import ee.jaltdorf.proovikontrolltoo1.entity.Movie;
import ee.jaltdorf.proovikontrolltoo1.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@AllArgsConstructor
@RestController
public class MovieController {

    private MovieRepository movieRepository;
    private ee.jaltdorf.decathlon.service.AthleteService athleteService;



    @GetMapping("movies")
    public List<Movie> getMovie(){
        return movieRepository.findAll();
    }

    @DeleteMapping("movies/{id}")
    public List<Movie> deleteMovie(@PathVariable Long id){
        movieRepository.deleteById(id);
        return movieRepository.findAll();
    }

    @PostMapping("movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    //Sportlase kogu punktisumma
    //@GetMapping("movies/{id}/points")
    //public double getAthletePoints(@PathVariable Long id) {
        //return movieService.calculateAthleteTotalPoints(id); }

}
