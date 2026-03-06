package ee.jaltdorf.decathlon.service;


import ee.jaltdorf.decathlon.entity.Athlete;
import ee.jaltdorf.decathlon.entity.Result;
import ee.jaltdorf.decathlon.exception.AthleteNotFoundException;
import ee.jaltdorf.decathlon.repository.AthleteRepository;
import org.springframework.stereotype.Service;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;
    private final ResultService resultService;

    public AthleteService(AthleteRepository athleteRepository,
                          ResultService resultService) {
        this.athleteRepository = athleteRepository;
        this.resultService = resultService;
    }
    public double calculateAthleteTotalPoints(Long athleteId) {
        Athlete athlete = athleteRepository.findById(athleteId)
                .orElseThrow(() -> new AthleteNotFoundException(athleteId));

        double total = 0;

        for (Result result : athlete.getResults()) {
            total += resultService.calculatePoints(result);
        }
        return total;
    }
}
