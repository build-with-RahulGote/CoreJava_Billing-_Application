

public class Product {

	private int ProdId;
	private String name;
	private int stock;
	private double price;
	public Product() {
		
	}
	public Product(int prodId,String name,int stock,double price)
	{
		this.ProdId=prodId;
		this.name=name;
		this.stock=stock;
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProdId() {
		return ProdId;
	}
	public void setProdId(int prodId) {
		ProdId = prodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	

}
