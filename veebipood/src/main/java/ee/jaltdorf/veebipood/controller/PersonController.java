package ee.jaltdorf.veebipood.controller;

import ee.jaltdorf.veebipood.dto.PersonLoginRecordDto;
import ee.jaltdorf.veebipood.entity.Person;
import ee.jaltdorf.veebipood.repository.PersonRepository;
import ee.jaltdorf.veebipood.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    //Dependency injection.
    @Autowired
    private PersonService personService;

    @GetMapping("person")
    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    @DeleteMapping("person/{id}")
    public List<Person> deletePerson(@PathVariable Long id){
        personRepository.deleteById(id); //kustutab
        return personRepository.findAll(); //siin on uuenenud seis
    }

    @PostMapping("signup")
    public Person signup(@RequestBody Person person){
        personService.validate(person);
        return personRepository.save(person);
    }

    @PostMapping("login")
    public Person login(@RequestBody PersonLoginRecordDto personDto){
        Person dbPerson = personRepository.findByEmail(personDto.email());
        if (dbPerson == null) {
            throw new RuntimeException("Invalid email");
        }
        if (!dbPerson.getPassword().equals(personDto.password())) {
            throw new RuntimeException("Invalid password");
        }
        return dbPerson;
    }
}
