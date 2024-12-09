package Application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ApplicationRecetteCulinaire {
	
	private List<Utilisateur> ListeUtilisateurEnregistrés;
	private List<Recette> ListeDeTouteLesRecettes;
	private List<Recette> ListeRecettesAffichees;
	protected List<Ingredient> ListeIngredientExistants;
	//private int IndexPage;

    public ApplicationRecetteCulinaire() {
        this.ListeUtilisateurEnregistrés = new ArrayList<>();
        this.ListeDeTouteLesRecettes = new ArrayList<>();
        this.ListeRecettesAffichees = new ArrayList<>();
        //this.IndexPage = 0;
    }

    //Méthode qui créer un utilisateur correctement instancier et l'ajoute dans la liste des utilisateur enregistrés
   
    public Utilisateur creerUtilisateur(int identifiant, String nom, String prenom) {
        Utilisateur nouvelUtilisateur = new Utilisateur(identifiant, nom, prenom);
        this.ListeUtilisateurEnregistrés.add(nouvelUtilisateur);
        return nouvelUtilisateur;
    }
    
    //Methode qui créer une recette correctement instanciée et l'ajoute dans la liste des recettes enregistrées
    
    public Recette creerUneRecette(int Identifiant, String Createur, String TitreRecette, String Description
			,List<String> ListeNomIngredient, List<Ingredient>listeIngredientsExistants) {
    	Recette nouvelleRecette = new Recette(Identifiant, Createur, TitreRecette, Description
			,ListeNomIngredient, listeIngredientsExistants);
    	this.ListeDeTouteLesRecettes.add(nouvelleRecette);
		return nouvelleRecette;
    }
    
    //Méthode qui permet d'afficher seulement les dix recettes selon leurs dans l'ordre alphabetic 
    // on suppose que chaque recette est différente
    public void ParTitre() {
        List<Recette> copieTriee = ListeDeTouteLesRecettes.stream()
                .sorted(Comparator.comparing(Recette::getTitreRecette))
                .collect(Collectors.toList());

        ListeRecettesAffichees = copieTriee.stream()
                .limit(10)
                .collect(Collectors.toList());
    }
    
    public void ParIngredient(List<Ingredient> ListeD_ingredient) {
        ListeRecettesAffichees = ListeDeTouteLesRecettes.stream()
                .filter(recette -> recette.getListeIngredient().containsAll(ListeD_ingredient))
                .collect(Collectors.toList());
    }
    
    protected void RechercheParMotCles(List<String> MotCles) {
    	ListeRecettesAffichees = ListeDeTouteLesRecettes.stream()
                .filter(recette -> {
                    String titreLowerCase = recette.getTitreRecette().toLowerCase();
                    return MotCles.stream()
                            .allMatch(mot -> titreLowerCase.contains(mot.toLowerCase()));
                })
                .collect(Collectors.toList());
    }
    
    protected void AfficherLeResultatRechercheOuTrie() {
    	System.out.println("Liste des utilisateurs enregistrés :");
        for (Utilisateur utilisateur : ListeUtilisateurEnregistrés) {
            System.out.println(utilisateur);
        }
        System.out.println("\n");
    	System.out.println("Liste des Recettes enregistrées");
    	for (Recette recette : ListeDeTouteLesRecettes) {
    		System.out.println(recette);
    	}
    }
    
    public boolean supprimerRecette(int idRecette) {
        
        for (Recette recette : ListeDeTouteLesRecettes) {
            if (recette.getIdentifiantRecette() == idRecette) {
                ListeDeTouteLesRecettes.remove(recette);
                System.out.println("Recette avec l'identifiant " + idRecette + " supprimée.");
                return true; 
            }
        }
        System.out.println("Aucune recette avec l'identifiant " + idRecette + " n'a été trouvée.");
        return false; 
    }
    
    public boolean supprimerRecetteUtilisateur(int idUtilisateur, int idRecette) {
    	
    	for (Utilisateur utilisateur : ListeUtilisateurEnregistrés) {
    		if (utilisateur.getIdentifiant() == idUtilisateur) {
    			for(Recette recette : utilisateur.getRecettesCreees()) {
    				if (recette.getIdentifiantRecette() == idRecette) {
    					utilisateur.ListRecetteCree.remove(idRecette);
    					System.out.println("L'utilisateur avec l'identifiant " + idUtilisateur + " à supprimer la recette d'identifiant " + idRecette);
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    protected void TrierParPopularité() {
    	List<Recette> copieTriee = ListeDeTouteLesRecettes.stream()
                .sorted(Comparator.comparing(Recette::getViewCount).reversed())
                .collect(Collectors.toList());

        ListeRecettesAffichees = copieTriee.stream()
                .limit(10)
                .collect(Collectors.toList());
    }
    
    protected void TrierParNotes() {
    	List<Recette> copieTriee = ListeDeTouteLesRecettes.stream()
                .sorted(Comparator.comparing(Recette::getNoteGeneral).reversed())
                .collect(Collectors.toList());

        ListeRecettesAffichees = copieTriee.stream()
                .limit(10)
                .collect(Collectors.toList());
    }
    
    public List<Utilisateur> getListeUtilisateurs() {
    	return ListeUtilisateurEnregistrés;
    }
    
    public List<Recette> getListeDeToutesLesRecette(){
    	return ListeDeTouteLesRecettes;
    }
    
    public List<Recette> getListeRecetteAffichees(){
    	return ListeRecettesAffichees;
    }
}
