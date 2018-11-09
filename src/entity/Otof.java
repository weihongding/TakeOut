package entity;

public class Otof {

	private int id;
	private int oid;
	private int fid;
	private int count;
	private double sum_price;

	/**
	 * 得到订单菜品关系
	 * @param oid
	 * @param fid
	 * @param count
	 * @param sum_price
	 */
	public Otof(int oid, int fid, int count, double sum_price) {
		setOid(oid);
		setFid(fid);
		setCount(count);
		setSum_price(sum_price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSum_price() {
		return sum_price;
	}

	public void setSum_price(double sum_price) {
		this.sum_price = sum_price;
	}

}
