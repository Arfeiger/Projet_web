package beans;

public class Commande {


	private int commandeId ;
	private int personId;
	private String category;
	private String price;
	private String nom;

	public Commande(int personId,String category, String price, String nom) {
		this.personId=personId;
		this.category = category;
		this.price = price;
		this.nom = nom;
	}

	public int getCommandeId() {
		return commandeId;
	}

	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}
