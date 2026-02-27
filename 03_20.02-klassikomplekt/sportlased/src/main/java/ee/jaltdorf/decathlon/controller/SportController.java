package ee.jaltdorf.decathlon.controller;


import ee.jaltdorf.decathlon.dto.ResultDto;
import ee.jaltdorf.decathlon.dto.SportDto;
import ee.jaltdorf.decathlon.entity.Athlete;
import ee.jaltdorf.decathlon.entity.Result;
import ee.jaltdorf.decathlon.entity.Sport;
import ee.jaltdorf.decathlon.repository.ResultRepository;
import ee.jaltdorf.decathlon.repository.SportRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class SportController {

    private SportRepository sportRepository;



    @GetMapping("sports")
    public List<Sport> getSport(){
        return sportRepository.findAll();
    }

    @DeleteMapping("sports/{id}")
    public List<Sport> deleteSport(@PathVariable Long id){
        sportRepository.deleteById(id);
        return sportRepository.findAll();
    }

    @PostMapping ("sports")
    public Sport addSport(@RequestBody Sport sport ) {
        return sportRepository.save(sport);
    }

}
