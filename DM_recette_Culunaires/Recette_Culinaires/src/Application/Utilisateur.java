package Application;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utilisateur {

	private int identifiant;
	private String nom;
	private String prenom;
	List<Recette> ListRecetteCree;
	List<Recette> ListRecetteSauv;
	private List<Recette> ListRecetteEssayees;
	
	public Utilisateur() {
	}
	
	public Utilisateur(int identifiant, String nom, String prenom) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.ListRecetteCree = new ArrayList<>();
		this.ListRecetteSauv = new ArrayList<>();
	}
	
	// Bloc de setters regroupés
    public void ModifierUtilisateur(int identifiant, String nom, String prenom, List<Recette> recettesSauvegardees, List<Recette> recettesCreees) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.ListRecetteSauv = recettesSauvegardees;
        this.ListRecetteCree = recettesCreees;
    }
	
	 // Getters et Setters
    public int getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    public List<Recette> getRecettesSauvegardees() {
        return ListRecetteSauv;
    }

    public List<Recette> getRecettesCreees() {
        return ListRecetteCree;
    }
    
    public void afficheListRecette() {
    	for (Recette recette : ListRecetteCree) {
    		System.out.println(recette);
    	}
    }

    // Méthodes pour manipuler les recettes
    protected void ajouterRecetteSauvegardee(Recette recette) {
        this.ListRecetteSauv.add(recette);
    }

    protected void ajouterRecetteCreee(Recette recette) {
        this.ListRecetteCree.add(recette);
    }
    
    @Override
    public boolean equals(Object o) {
    	if(this==o) return true;
    	if(o == null || getClass()!= o.getClass()) return false;
		Utilisateur utilisateur = (Utilisateur) o;
		return identifiant == utilisateur.identifiant &&
				Objects.equals(nom, utilisateur.nom) &&
				Objects.equals(prenom, utilisateur.prenom) &&
				Objects.equals(ListRecetteCree, utilisateur.ListRecetteCree) &&
				Objects.equals(ListRecetteSauv, utilisateur.ListRecetteSauv) &&
				Objects.equals(ListRecetteEssayees, utilisateur.ListRecetteEssayees);
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(identifiant, nom, prenom, ListRecetteCree, ListRecetteSauv, ListRecetteEssayees);
    }
    
    @Override
    public String toString() {
        return "Utilisateur{" +
               "identifiant=" + identifiant +
               ", nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' +
               ", recettesSauvegardees=" + ListRecetteSauv +
               ", recettesCreees=" + ListRecetteCree +
               '}';
    }
    
    private void Deconnection() {
    }
    
    

}
