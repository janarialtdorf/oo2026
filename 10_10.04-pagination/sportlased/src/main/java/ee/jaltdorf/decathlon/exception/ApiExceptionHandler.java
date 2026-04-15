package ee.jaltdorf.decathlon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ApiExceptionHandler {

    // 404 - Sportlast ei leitud
    @ExceptionHandler(AthleteNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAthleteNotFound(AthleteNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // 404 - Spordiala ei leitud
    @ExceptionHandler(SportNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleSportNotFound(SportNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // 404 - Tulemust ei leitud
    @ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResultNotFound(ResultNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // 400 - Puuduv request parameter
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorMessage> handleMissingParam(MissingServletRequestParameterException ex) {
        return buildResponse("Puuduv päringu parameeter: " + ex.getParameterName(),
                HttpStatus.BAD_REQUEST);
    }

    // 500 - Kõik muud vead
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception ex) {
        return buildResponse("Serveri viga: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorMessage> buildResponse(String message, HttpStatus status) {

        ErrorMessage error = new ErrorMessage();
        error.setMessage(message);
        error.setStatus(status.value());
        error.setTimestamp(new Date());

        return ResponseEntity.status(status).body(error);
    }

}
