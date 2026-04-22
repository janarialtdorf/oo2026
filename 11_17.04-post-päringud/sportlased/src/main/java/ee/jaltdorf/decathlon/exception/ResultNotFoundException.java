package ee.jaltdorf.decathlon.exception;

public class ResultNotFoundException extends RuntimeException {
    public ResultNotFoundException(Long id) {
        super("Sellise ID-ga tulemust ei leitud!");
    }
}
