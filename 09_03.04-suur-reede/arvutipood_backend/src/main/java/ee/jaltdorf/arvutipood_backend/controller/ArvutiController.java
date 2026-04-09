package ee.jaltdorf.arvutipood_backend.controller;

import ee.jaltdorf.arvutipood_backend.entity.Arvuti;
import ee.jaltdorf.arvutipood_backend.entity.Lauaarvuti;
import ee.jaltdorf.arvutipood_backend.entity.Sylearvuti;
import ee.jaltdorf.arvutipood_backend.repository.ArvutiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ArvutiController {

    @Autowired
    private ArvutiRepository arvutiRepository;

    // kõik arvutid
    @GetMapping("arvuti")
    public List<Arvuti> getArvutid() {
        return arvutiRepository.findAll();
    }

    // Sülearvuti lisamine
    @PostMapping("arvuti/syle")
    public List<Arvuti> addSylearvuti(@RequestBody Sylearvuti arvuti) {
        arvutiRepository.save(arvuti);
        return arvutiRepository.findAll();
    }

    // Lauaarvuti lisamine
    @PostMapping("arvuti/laua")
    public List<Arvuti> addLauaarvuti(@RequestBody Lauaarvuti arvuti) {
        arvutiRepository.save(arvuti);
        return arvutiRepository.findAll();
    }

    // Arvuti kustutamine
    @DeleteMapping("arvuti/{id}")
    public List<Arvuti> deleteArvuti(@PathVariable Long id) {
        arvutiRepository.deleteById(id);
        return arvutiRepository.findAll();
    }
}