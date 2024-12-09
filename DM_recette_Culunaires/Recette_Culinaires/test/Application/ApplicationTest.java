package Application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ApplicationTest {

	@Test
	void test() {
		ApplicationRecetteCulinaire App = new ApplicationRecetteCulinaire();
		App.creerUtilisateur(1, "ROCKA", "Haumana");
		App.ListeIngredientExistants = Arrays.asList(
			new Ingredient(1, "pomme"),
			new Ingredient(2, "Carotte"),
			new Ingredient(3, "pomme de terre")
		);
		
		App.creerUneRecette(101, "Rocka Haumana", "Tarte aux pommes", "Une délicieuse tarte aux pommes.", Arrays.asList("pomme"), App.ListeIngredientExistants);
        App.creerUneRecette(102, "Rocka Haumana", "Soupe de carotte", "Une soupe de carotte exquise.", Arrays.asList("Carotte"), App.ListeIngredientExistants);
        App.creerUneRecette(103, "Roger Bichard", "Boulliant de carotte", "Un bouillant de légumes.", Arrays.asList("Carotte", "pomme de terre"), App.ListeIngredientExistants);
        
        //recette1
        App.getListeDeToutesLesRecette().get(0).setNoteGeneral(3.4f);
        App.getListeDeToutesLesRecette().get(0).setViewCount(6);
        
        //recette2
        App.getListeDeToutesLesRecette().get(1).setNoteGeneral(3.9f);
        App.getListeDeToutesLesRecette().get(1).setViewCount(18);
        
        //recette3
        App.getListeDeToutesLesRecette().get(2).setNoteGeneral(3f);
        App.getListeDeToutesLesRecette().get(2).setViewCount(10);
        
        App.RechercheParMotCles(Arrays.asList("carotte"));
        
        Recette r1 = new Recette(101, "Rocka Haumana", "Tarte aux pommes", "Une délicieuse tarte aux pommes.", Arrays.asList("pomme"), App.ListeIngredientExistants);
        r1.setNoteGeneral(3.4f);
        r1.setViewCount(6);
        
        Recette r2 = new Recette(102, "Rocka Haumana", "Soupe de carotte", "Une soupe de carotte exquise.", Arrays.asList("Carotte"), App.ListeIngredientExistants);
        r2.setNoteGeneral(3.9f);
        r2.setViewCount(18);
        
        Recette r3 = new Recette(103, "Roger Bichard", "Boulliant de carotte", "Un bouillant de légumes.", Arrays.asList("Carotte", "pomme de terre"), App.ListeIngredientExistants);
        r3.setNoteGeneral(3f);
        r3.setViewCount(10);
        
        List<Recette> ListeDeRecetteAttendue = new ArrayList<>();
        ListeDeRecetteAttendue.add(r2);
        ListeDeRecetteAttendue.add(r3);
        
        assertEquals(ListeDeRecetteAttendue, App.getListeRecetteAffichees());
    }

}
