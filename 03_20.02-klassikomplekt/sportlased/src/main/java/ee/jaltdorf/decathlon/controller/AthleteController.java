package ee.jaltdorf.decathlon.controller;

import ee.jaltdorf.decathlon.dto.AthleteDto;
import ee.jaltdorf.decathlon.entity.Athlete;
import ee.jaltdorf.decathlon.repository.AthleteRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class AthleteController {

    private AthleteRepository athleteRepository;
    private ee.jaltdorf.decathlon.service.AthleteService athleteService;



    @GetMapping("athletes")
    public List<Athlete> getAthlete(){
        return athleteRepository.findAll();
    }

    @DeleteMapping("athletes/{id}")
    public List<Athlete> deleteAthlete(@PathVariable Long id){
        athleteRepository.deleteById(id);
        return athleteRepository.findAll();
    }

    @PostMapping ("athletes")
    public Athlete addAthlete(@RequestBody Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    //Sportlase kogu punktisumma
    @GetMapping("athletes/{id}/points")
    public double getAthletePoints(@PathVariable Long id) {
        return athleteService.calculateAthleteTotalPoints(id); }

}
