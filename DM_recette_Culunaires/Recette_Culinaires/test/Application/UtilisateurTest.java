package Application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


class UtilisateurTest {

	@Test
	void test() {
		Utilisateur u1 = new Utilisateur(1, "ROCKA", "Haumana");
		List<Ingredient> listeIngredientsExistants = Arrays.asList(
				new Ingredient(1, "pomme")
		);
		Recette r1 = new Recette(101, u1.getPrenom(), 
	            "Tarte aux pommes", "Une délicieuse tarte aux pommes.", 
	            Arrays.asList("pomme"), listeIngredientsExistants);
		// Ajouter la recette à la liste des recettes créées par l'utilisateur
        u1.ajouterRecetteCreee(r1);
        //u1.afficheListRecette();

        // Attendu : une liste contenant la recette
        List<Recette> recettesAttendue = new ArrayList<>();
        recettesAttendue.add(r1);
        
        // Assertion
        assertEquals(recettesAttendue, u1.getRecettesCreees());
	}

}
