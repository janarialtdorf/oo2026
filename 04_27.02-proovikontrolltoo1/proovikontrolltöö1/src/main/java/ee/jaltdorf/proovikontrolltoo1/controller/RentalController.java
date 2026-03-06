package ee.jaltdorf.proovikontrolltoo1.controller;

import ee.jaltdorf.proovikontrolltoo1.entity.Rental;
import ee.jaltdorf.proovikontrolltoo1.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@AllArgsConstructor
@RestController
public class RentalController {

    private RentalRepository rentalRepository;
    private ee.jaltdorf.proovikontrolltoo1.service.RentalService rentalService;



    @GetMapping("rental")
    public List<Rental> getRental(){
        return rentalRepository.findAll();
    }

    @DeleteMapping("rental/{id}")
    public List<Rental> deleteRental(@PathVariable Long id){
        rentalRepository.deleteById(id);
        return rentalRepository.findAll();
    }

    @PostMapping("rental")
    public Rental addRental(@RequestBody Rental rental) {
        return rentalRepository.save(rental);
    }

    //Sportlase kogu punktisumma
    //@GetMapping("movies/{id}/points")
    //public double getAthletePoints(@PathVariable Long id) {
    //return movieService.calculateAthleteTotalPoints(id); }

}
