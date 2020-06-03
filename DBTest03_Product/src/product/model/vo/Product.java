package product.model.vo;

public class Product {
	private String pId;
	private String pName;
	private int price;
	private String desc;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String pId, String pName, int price, String desc) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.desc = desc;
	}
	//update에 사용될 생성자
	public Product(String pId, int price) {
		super();
		this.pId = pId;
		this.price = price;
	}
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", price=" + price + ", desc=" + desc + "]";
	}
	
}
