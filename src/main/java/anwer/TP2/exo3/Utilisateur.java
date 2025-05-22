package anwer.TP2.exo3;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private int id;

    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // Méthode de validation
    public boolean estValide() {
        return nom != null && !nom.trim().isEmpty() &&
                prenom != null && !prenom.trim().isEmpty() &&
                email != null && !email.trim().isEmpty();
    }
}