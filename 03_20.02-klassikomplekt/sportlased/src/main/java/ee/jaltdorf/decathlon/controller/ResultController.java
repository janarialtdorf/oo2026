package ee.jaltdorf.decathlon.controller;


import ee.jaltdorf.decathlon.dto.ResultDto;
import ee.jaltdorf.decathlon.entity.Athlete;
import ee.jaltdorf.decathlon.entity.Result;
import ee.jaltdorf.decathlon.repository.ResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ResultController {


    private ResultRepository resultRepository;



    @GetMapping("results")
    public List<Result> getResult(){
        return resultRepository.findAll();
    }

    @DeleteMapping("results/{id}")
    public List<Result> deleteResult(@PathVariable Long id){
        resultRepository.deleteById(id);
        return resultRepository.findAll();
    }

    @PostMapping ("results")
    public Result addResult(@RequestBody Result result) {
        return resultRepository.save(result);
    }

}
