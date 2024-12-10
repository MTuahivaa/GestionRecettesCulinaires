package Application;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Recette {
	private int IdentifaintRecette;
	private String Createur;
	private String TitreRecette;
	private String Description;
	private List<Commentaire> listeDeCommentaires;
	private float noteGeneral;
	private List<Ingredient> ListeIngredient;
	private int viewCount;

	
	public Recette(int Identifiant, String Createur, String TitreRecette, String Description
			,List<String> ListeNomIngredient, List<Ingredient>listeIngredientsExistants) {
		// TODO Auto-generated constructor stub
		this.IdentifaintRecette = Identifiant;
		this.Createur = Createur;
		this.TitreRecette = TitreRecette;
		this.Description = Description;
		this.ListeIngredient = ListeNomIngredient.stream()
	            .map(nom -> trouverIngredientParNom(nom, listeIngredientsExistants))
	            .collect(Collectors.toList());
		this.listeDeCommentaires = new ArrayList<>();
		this.noteGeneral = 0;
		this.viewCount = 0;
	}
	
	protected void modifierLaRecette(String TitreRecette, String Description
			,List<Ingredient>ListeIngredient) {
		this.TitreRecette = TitreRecette;
		this.Description = Description;
		this.ListeIngredient = ListeIngredient;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Recette recette = (Recette) o;
	        return IdentifaintRecette == recette.IdentifaintRecette &&
	               Objects.equals(Createur, recette.Createur) &&
	               Objects.equals(TitreRecette, recette.TitreRecette) &&
	               Objects.equals(Description, recette.Description) &&
	               Objects.equals(ListeIngredient, recette.ListeIngredient) &&
	               Objects.equals(noteGeneral, recette.noteGeneral) &&
	               Objects.equals(viewCount, recette.viewCount);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(IdentifaintRecette, Createur, TitreRecette, Description, ListeIngredient, noteGeneral, viewCount);
	    }
	
	@Override
    public String toString() {
        return "Recette{" +
               "IdentifaintRecette=" + IdentifaintRecette +
               ", Createur='" + Createur + '\'' +
               ", TitreRecette='" + TitreRecette + '\'' +
               ", Description='" + Description + '\'' +
               ", ListeIngredient=" + ListeIngredient +
               ", NoteGeneral= " + noteGeneral +
               ", ViewCount= " + viewCount +
               "}\n";
    }

	public int getIdentifiantRecette() {
		// TODO Auto-generated method stub
		return IdentifaintRecette;
	}
	
	public String getTitreRecette() {
		return TitreRecette;
	}

	public List<Ingredient> getListeIngredient(){
		return ListeIngredient;
	}
		
	public float getNoteGeneral() {
		return noteGeneral;
	}

	/*public void setNoteGeneral(float noteGeneral) {
		this.noteGeneral = noteGeneral;
	}*/

	public String getCreateur() {
		return Createur;
	}
	
	public int getViewCount() {
		return viewCount;
	}
	
	/*protected void setViewCount(int nb) {
		this.viewCount = nb;
	}*/

	public List<Commentaire> getListeDeCommentaires() {
		return listeDeCommentaires;
	}

	public Commentaire ajouterUnCommentaire(String Auteur, String Avis, float noteDonner) {
		Commentaire nouveauCommentaire = new Commentaire(Auteur, Avis, noteDonner);
		this.listeDeCommentaires.add(nouveauCommentaire);
		return nouveauCommentaire;
	}
	
	public void MiseAjourDeLaNoteGeneral() {
		float res = CalculeDeLaMoyenne(listeDeCommentaires);
		this.noteGeneral = res;
	}
	
	private float CalculeDeLaMoyenne(List<Commentaire> commentaires) {
		if (commentaires == null || commentaires.isEmpty()) {
	        return 0; 
	    }
	    
	    float somme = 0;
	    for (Commentaire commentaire : commentaires) {
	        somme += commentaire.getNoteDonner(); 
	    }
	    
	    float moyenne =  somme / commentaires.size();
	    
	    
	    return Math.round(moyenne * 10) / 10.0f;
	    
	}
	
	private static Ingredient trouverIngredientParNom(String nom, List<Ingredient> listeIngredientsExistants) {
	    return listeIngredientsExistants.stream()
	            .filter(ingredient -> ingredient.getNom().equalsIgnoreCase(nom))
	            .findFirst()
	            .orElseGet(() -> {
	                // on créer un nouvel objet de type Ingredient si il n'existe pas déja
	                int nouvelId = listeIngredientsExistants.size() + 1;
	                Ingredient nouvelIngredient = new Ingredient(nouvelId, nom);
	                listeIngredientsExistants.add(nouvelIngredient); // Ajouter à la liste des ingrédients existants
	                return nouvelIngredient;
	            });
	}

}
