package ee.jaltdorf.proovikontrolltoo1.dto;

import java.time.LocalDate;

public record RentalDto(
    LocalDate dueDate,
    Double price
) {
}
