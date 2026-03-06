package ee.jaltdorf.KT1_Kiirus.controller;


import ee.jaltdorf.KT1_Kiirus.dto.VelocityMphDto;
import ee.jaltdorf.KT1_Kiirus.entity.Velocity;
import ee.jaltdorf.KT1_Kiirus.entity.VelocityMph;
import ee.jaltdorf.KT1_Kiirus.repository.VelocityMphRepository;
import ee.jaltdorf.KT1_Kiirus.repository.VelocityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VelocityController {

    @Autowired
    private VelocityRepository velocityRepository;

    @Autowired
    private VelocityMphRepository velocityMphRepository;


//1. punkt
    @GetMapping("velocity")
    public List<Velocity> getVelocity(){
        return velocityRepository.findAll();
    }

    @PostMapping("velocity")
    public List<Velocity> addVelocity(@RequestBody Velocity velocity){

        if (velocity.getNumber() == null) {
            throw new RuntimeException("Kiirus ei tohi olla tühi!");
        }

        if (velocity.getNumber() < 0) {
            throw new RuntimeException("Kiirus ei tohi olla negatiivne!");
        }

        velocityRepository.save(velocity); //siin salvestab
        return velocityRepository.findAll(); //siin on uuenenud seis
    }

//2. punkt
    @GetMapping("velocity/average")
    public double getAverageVelocity() {
        List<Velocity> velocity = velocityRepository.findAll();

        if (velocity.isEmpty()) {
            throw new RuntimeException("Andmebaasis pole kiiruseid!");
        }

        double sum = 0;
        for (Velocity v : velocity) {
            sum += v.getNumber();
        }

        return sum / velocity.size();
    }

    @GetMapping("velocity/mph")
    public List<VelocityMphDto> getAllVelocitiesInMphWithId() {
        return velocityRepository.findAll().stream()
                .map(v -> new VelocityMphDto(v.getId(), v.getNumber() * 0.621371))
                .toList();
    }

//3. punkt
    @GetMapping("velocity/allMph")
    public List<VelocityMph> getVelocityMph(){
    return velocityMphRepository.findAll();
}


    @PostMapping("velocity/saveMph")
    public String saveAllVelocitiesInMph() {
        List<Velocity> velocity = velocityRepository.findAll();

        for (Velocity v : velocity) {
            double mphValue = v.getNumber() * 0.621371;
            VelocityMph mphRecord = new VelocityMph();
            mphRecord.setMph(mphValue);
            velocityMphRepository.save(mphRecord);
        }

        return velocity.size() + " kiirust teisendatud ja salvestatud mph tabelisse.";
    }

    @PutMapping("velocity/incrementAllMph")
    public String incrementAllMph() {
        List<VelocityMph> mphList = velocityMphRepository.findAll();

        for (VelocityMph v : mphList) {
            v.setMph(v.getMph() + 1);
        }

        velocityMphRepository.saveAll(mphList);

        return "Kõik kirjed on suurendatud 1 võrra.";
    }

    @DeleteMapping("/velocity/deleteAllMph")
    public String deleteAllMph() {
        velocityMphRepository.deleteAll();
        return "Kõik kirjed mph tabelist kustutatud!";
    }

}
