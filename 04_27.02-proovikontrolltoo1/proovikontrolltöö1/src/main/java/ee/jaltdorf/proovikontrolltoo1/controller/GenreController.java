package ee.jaltdorf.proovikontrolltoo1.controller;

import ee.jaltdorf.proovikontrolltoo1.entity.Genre;
import ee.jaltdorf.proovikontrolltoo1.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
public class GenreController {

    private GenreRepository genreRepository;



    @GetMapping("genres")
    public List<Genre> getGenre(){
        return genreRepository.findAll();
    }

    @DeleteMapping("genres/{id}")
    public List<Genre> deleteGenre(@PathVariable Long id){
        genreRepository.deleteById(id);
        return genreRepository.findAll();
    }

    @PostMapping("genres")
    public Genre addGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

}
