package ee.jaltdorf.decathlon.exception;

public class AthleteNotFoundException extends RuntimeException {
    public AthleteNotFoundException(Long id) {
        super("Sellise ID-ga sportlast ei leitud!");
    }
}

