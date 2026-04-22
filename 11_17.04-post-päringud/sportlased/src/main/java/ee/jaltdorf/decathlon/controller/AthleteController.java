package ee.jaltdorf.decathlon.controller;

import ee.jaltdorf.decathlon.dto.AthleteDto;
import ee.jaltdorf.decathlon.entity.Athlete;
import ee.jaltdorf.decathlon.repository.AthleteRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin (origins = "*")
@AllArgsConstructor
@RestController
public class AthleteController {

    private AthleteRepository athleteRepository;
    private ee.jaltdorf.decathlon.service.AthleteService athleteService;



    @GetMapping("athletes")
    public Page<Athlete> getAthlete(Pageable pageable, @RequestParam(required = false) String country
    ) {
        if (country == null || country.equals("all")) {
            return athleteRepository.findAll(pageable);
        }
        return athleteRepository.findByCountry(country, pageable);
    }

    @DeleteMapping("/athletes/{id}")
    public List<Athlete> deleteAthlete(@PathVariable Long id){
        athleteRepository.deleteById(id);
        return athleteRepository.findAll();
    }

    @PostMapping("athletes")
    public Athlete addAthlete(@RequestBody Athlete athlete) {
        athlete.setResult(new ArrayList<>()); // alati reset
        return athleteRepository.save(athlete);
    }

    //Sportlase kogu punktisumma
    @GetMapping("athletes/{id}/points")
    public double getAthletePoints(@PathVariable Long id) {
        return athleteService.calculateAthleteTotalPoints(id);
    }

    @DeleteMapping("/athletes")
    public List<Athlete> deleteAllAthletes() {
        athleteRepository.deleteAll();
        return athleteRepository.findAll();
    }

}
