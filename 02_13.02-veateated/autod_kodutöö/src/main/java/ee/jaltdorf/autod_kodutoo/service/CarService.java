package ee.jaltdorf.autod_kodutoo.service;

import ee.jaltdorf.autod_kodutoo.entity.Car;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CarService {
    public void validate(Car car){
        if (car.getId() != null) {
            throw new RuntimeException("New car must not have ID");
        }
        if (car.getBrand() != null) {
            if (car.getBrand() == null || car.getBrand().isBlank()) {
                throw new RuntimeException("Brand is required");
            }
        }
        if (car.getModel() == null || car.getModel().isBlank()) {
            throw new RuntimeException("Model is required");
        }
        if (car.getBrand().length() < 3) {
            throw new RuntimeException("Brand must be at least 3 characters");
        }
    }

}
