package molotov.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cocktails")
@NamedQueries({
	@NamedQuery(name="allCocktails", query="SELECT c FROM Cocktail c")
})
public class Cocktail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private String nom;
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Ustensile> ustensiles;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Dose> doses;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Etape> etapes;

	public Cocktail() {}
	
	public Cocktail(String nom, List<Ustensile> ustensile, List<Dose> dose, List<Etape> etape) {
		this.nom = nom;
		this.ustensiles = ustensile;
		this.doses = dose;
		this.etapes = etape;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Ustensile> getUstensile() {
		return ustensiles;
	}

	public void setUstensile(List<Ustensile> ustensile) {
		this.ustensiles = ustensile;
	}

	public List<Dose> getDose() {
		return doses;
	}

	public void setDose(List<Dose> dose) {
		this.doses = dose;
	}

	public List<Etape> getEtape() {
		return etapes;
	}

	public void setEtape(List<Etape> etape) {
		this.etapes = etape;
	}
	
}
