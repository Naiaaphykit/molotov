package molotov.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Cette classe représente la dose nécessaire d'un ingrédient pour la fabrication d'un cocktail.
 * 
 * @author Adminl
 *
 */
@Entity
@Table(name="doses")
public class Dose {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(optional=false, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Ingredient ingredient;
	
	@Column(nullable=false)
	private double quantite;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Unite unite;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public Unite getUnite() {
		return unite;
	}
	public void setUnite(Unite unite) {
		this.unite = unite;
	}
	
}
