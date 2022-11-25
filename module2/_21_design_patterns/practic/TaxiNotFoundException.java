package _21_design_patterns.practic;

public class TaxiNotFoundException extends RuntimeException {
    public TaxiNotFoundException(String message) {
        System.out.println(message);
    }
}
