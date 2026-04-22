package ee.jaltdorf.decathlon.service;

import ee.jaltdorf.decathlon.entity.Result;
import ee.jaltdorf.decathlon.entity.Sport;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    //Puntkisummade arvutamine
    public double calculatePoints(Result result) {
        Sport sport = result.getSport();
        double value = result.getResults();

        if (sport == null) {
            return 0;
        }

        String type = sport.getScoringType();

        switch (type) {
            case "TIME":
                return Math.max(0, 1000 - (value * 60));

            case "DISTANCE":
                return value * 100;

            case "COUNT":
                return value * 10;

            default:
                return 0;
        }
    }

}
