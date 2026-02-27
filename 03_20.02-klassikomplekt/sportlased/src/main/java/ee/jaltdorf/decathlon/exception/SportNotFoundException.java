package ee.jaltdorf.decathlon.exception;

public class SportNotFoundException extends RuntimeException {
    public SportNotFoundException(Long id) {
        super("Sellise ID-ga spordiala ei leitud!");
    }
}
