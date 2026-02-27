package ee.jaltdorf.autod_kodutoo.controller;

import ee.jaltdorf.autod_kodutoo.dto.CarDto;
import ee.jaltdorf.autod_kodutoo.entity.Car;
import ee.jaltdorf.autod_kodutoo.repository.CarRepository;
import ee.jaltdorf.autod_kodutoo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @GetMapping("cars")
    public List<Car> getCar(){
        return carRepository.findAll();
    }

    @DeleteMapping("cars/{id}")
    public List<Car> deleteCar(@PathVariable Long id){
        carRepository.deleteById(id);
        return carRepository.findAll();
    }

    @PostMapping("cars")
    public Car addCar(@RequestBody Car car){
        carService.validate(car);
        return carRepository.save(car);
    }

    @PostMapping("cars/find")
    public Car findCar(@RequestBody CarDto carDto){
        Car dbCar = carRepository.findByModel(carDto.model());

        if (dbCar == null) {
            throw new RuntimeException("Invalid model");
        }
        if (!dbCar.getBrand().equals(carDto.brand())) {
            throw new RuntimeException("Invalid brand");
        }
        return dbCar;
    }
}
