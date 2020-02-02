package beans;

public class Panier {

	private int panierId ;
	private int personId;
	private int productId;
	private String category;
	private String price;
	private String nom;

	public Panier(String category, String price, String nom) {
		this.category = category;
		this.price = price;
		this.nom = nom;
	}
	public int getPanierId() {
		return panierId;
	}
	public void setPanierId(int panierId) {
		this.panierId = panierId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
