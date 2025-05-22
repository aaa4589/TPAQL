package anwer.TP2.exo4;

public class DebitImpossibleException extends Exception {
    
    public DebitImpossibleException() {
        super("Débit impossible : fonds insuffisants");
    }
    
    public DebitImpossibleException(String message) {
        super(message);
    }
} 