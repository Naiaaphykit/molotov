package molotov.entities;

import javax.persistence.Entity;

@Entity
public class Alcool extends Ingredient {
	
	private double titre;
	

	public double getTitre() {
		return titre;
	}

	public void setTitre(double titre) {
		this.titre = titre;
	}
	

}
