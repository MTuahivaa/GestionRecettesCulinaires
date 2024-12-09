package Application;

import java.util.Objects;

public class Ingredient {

	private int IngredientId; 
	private String nomIgredient;
	
	public Ingredient() {
		
	}
	
	public Ingredient(int IngredientId, String nomIngredient) {
		this.IngredientId = IngredientId;
		this.nomIgredient = nomIngredient;
	}
	
	public int getId() {
        return IngredientId;
    }

    public String getNom() {
        return nomIgredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return IngredientId == that.IngredientId && Objects.equals(nomIgredient, that.nomIgredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IngredientId, nomIgredient);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
               "id=" + IngredientId +
               ", nom='" + nomIgredient + '\'' +
               '}';
    }

}
