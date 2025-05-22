package anwer.TP2.exo4;

public class Jeu {
    private Banque banque;
    private boolean ouvert;

    public Jeu(Banque banque) {
        this.banque = banque;
        this.ouvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        // Check if game is open
        if (!estOuvert()) {
            throw new JeuFermeException();
        }

        // Check if bank is solvent before starting
        if (!banque.est_solvable()) {
            fermer();
            throw new JeuFermeException();
        }

        try {
            // Get and validate bet
            int mise = joueur.mise();
            if (mise <= 0) {
                throw new IllegalArgumentException("La mise doit être positive");
            }

            // Debit player and credit bank
            joueur.debiter(mise);
            banque.crediter(mise);

            // Roll dice
            int resultat1 = de1.lancer();
            int resultat2 = de2.lancer();
            int somme = resultat1 + resultat2;

            if (somme == 7) {
                // Player wins
                int gain = mise * 2;
                banque.debiter(gain);
                joueur.crediter(gain);

                // Check bank solvency after payment
                if (!banque.est_solvable()) {
                    fermer();
                }
            }

        } catch (DebitImpossibleException e) {
            // If player can't pay, game stops there
            return;
        }
    }

    public void fermer() {
        this.ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}