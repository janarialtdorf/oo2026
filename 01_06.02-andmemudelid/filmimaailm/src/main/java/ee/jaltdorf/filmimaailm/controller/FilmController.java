package ee.jaltdorf.filmimaailm.controller;

import ee.jaltdorf.filmimaailm.entity.Film;
import ee.jaltdorf.filmimaailm.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("films")
    public List<Film> getFilms(){
        return filmRepository.findAll();
    }

    @DeleteMapping("films/{id}")
    public List<Film> deleteFilms(@PathVariable Long id){
        filmRepository.deleteById(id);
        return filmRepository.findAll();
    }

    @PostMapping("films")
    public List<Film> addFilms(@RequestBody Film film){
        filmRepository.save(film);
        return filmRepository.findAll();
    }

}
