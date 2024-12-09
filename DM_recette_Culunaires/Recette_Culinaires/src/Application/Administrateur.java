package Application;

import java.util.List;

public class Administrateur extends Utilisateur{

	private String Role;
	
	public Administrateur() {
		super();
        this.Role = "Administrateur";
	}
	

    public Administrateur(int identifiant, String nom, String prenom) {
        super(identifiant, nom, prenom);
        this.Role = "Administrateur";
    }
    
    //Pour la sociéte derriere l'application
    public void setRole(String role) {
        this.Role = role;
    }
    
    public void supprimerRecette(List<Recette> listeRecettes, int idRecette) {
        listeRecettes.removeIf(recette -> recette.getIdentifiantRecette() == idRecette);
        System.out.println("Recette avec l'identifiant " + idRecette + " supprimée.");
    }

}
