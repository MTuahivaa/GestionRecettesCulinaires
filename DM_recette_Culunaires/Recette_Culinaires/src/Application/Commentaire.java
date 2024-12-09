package Application;

public class Commentaire {

	private String Auteur;
	private String Avis;
	private float NoteDonner;
	
	public Commentaire(String NomAuteur, String Avis, float NoteD) {
		this.Auteur = NomAuteur;
		this.Avis = Avis;
		this.NoteDonner = NoteD;
		
	}
	
	public void ModifierLeCommentaire(String NomAuteur, String Avis, float NoteD) {
		this.Auteur = NomAuteur;
		this.Avis = Avis;
		this.NoteDonner = NoteD;
	}

	public String getAuteur() {
		return Auteur;
	}

	public String getAvis() {
		return Avis;
	}

	public float getNoteDonner() {
		return NoteDonner;
	}
	

}
