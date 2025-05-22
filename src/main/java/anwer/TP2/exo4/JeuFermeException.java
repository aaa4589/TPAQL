package anwer.TP2.exo4;

public class JeuFermeException extends Exception {
    
    public JeuFermeException() {
        super("Le jeu est fermé");
    }
    
    public JeuFermeException(String message) {
        super(message);
    }
} 