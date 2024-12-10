package Application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class RecetteTest {

	@Test
	void test() {
		List<Ingredient> ListeIngredientsExistants = Arrays.asList(
				new Ingredient(1, "pomme")
		);
		Recette R1 = new Recette(101, "Rocka Haumana", "Tarte aux pommes", "Une délicieuse tarte aux pommes.", Arrays.asList("pomme"), ListeIngredientsExistants);
		
		R1.ajouterUnCommentaire("Roger Bichard", "trés bonne recette", 4.5f);
		R1.ajouterUnCommentaire("Rina Calo", "Recette trop simpliste mais goût assez correcte", 3.4f);
		R1.ajouterUnCommentaire("Pholipe Etchebey", "Manque de raffinement, trop barbare", 2.8f);
		
		R1.MiseAjourDeLaNoteGeneral();
		
		System.out.print(R1.getNoteGeneral());
		
		assertEquals(3.6f, R1.getNoteGeneral());
	}

}
