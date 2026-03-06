package ee.jaltdorf.proovikontrolltoo1.service;

import ee.jaltdorf.proovikontrolltoo1.entity.Rental;
import ee.jaltdorf.proovikontrolltoo1.repository.MovieRepository;
import ee.jaltdorf.proovikontrolltoo1.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.geom.Rectangle2D;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final MovieRepository movieRepository;

    private static final Double LATE_FEE_PER_DAY = Double.valueOf(2);

    /**
     * Arvutab kõikide aktiivsete (tagastamata) rentalite koguhinna
     */
    public Double calculateCartTotal() {
        List<Rental> activeRentals = rentalRepository.findByReturnedAtIsNull();

        return activeRentals.stream()
                .map(this::calculateRentalPrice)
                .reduce(Double.ZERO, Rectangle2D.Double::add);
    }
}
