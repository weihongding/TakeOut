package entity;

public class Food {

	private int id;
	private String name;
	private double price;
	private String image;
	private int bid;
	
	/**
	 * 新增菜品/得到菜品实例
	 * 
	 * @param name
	 * @param des
	 * @param price
	 * @param image
	 * @param bid
	 */
	public Food(String name, double price, String image, int bid) {
		if(image.equals("")) image = "NotImage.jpg";
		setName(name);
		setPrice(price);
		setImage(image);
		setBid(bid);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
