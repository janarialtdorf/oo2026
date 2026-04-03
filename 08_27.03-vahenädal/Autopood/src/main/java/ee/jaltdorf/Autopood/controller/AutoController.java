package ee.jaltdorf.Autopood.controller;

import ee.jaltdorf.Autopood.entity.Auto;
import ee.jaltdorf.Autopood.entity.Bensiiniauto;
import ee.jaltdorf.Autopood.entity.Elektriauto;
import ee.jaltdorf.Autopood.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoController {

    @Autowired
    private AutoRepository autoRepository;

    // kõik autod
    @GetMapping("auto")
    public List<Auto> getAutod(){
        return autoRepository.findAll();
    }

    // Bensiiniautode lisamine
    @PostMapping("auto/bensiin")
    public List<Auto> addBensiiniauto(@RequestBody Bensiiniauto auto){
        autoRepository.save(auto);
        return autoRepository.findAll();
    }

    // Elektriautode lisamine
    @PostMapping("auto/elekter")
    public List<Auto> addElektriauto(@RequestBody Elektriauto auto){
        autoRepository.save(auto);
        return autoRepository.findAll();
    }

    // Autode kustutamine
    @DeleteMapping("auto/{id}")
    public List<Auto> deleteAuto(@PathVariable Long id){
        autoRepository.deleteById(id);
        return autoRepository.findAll();
    }
}