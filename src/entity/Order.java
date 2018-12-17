package entity;

import java.util.Date;

public class Order {

	private int id;
	private int bid;
	private int cid;
	private double total_price;
	private Date time;
	private String state;

	/**
	 * 新增订单
	 * 
	 * @param bid
	 * @param cid
	 * @param total_price
	 */
	public Order(int bid, int cid) {
		setBid(bid);
		setCid(cid);
	}

	/**
	 * 得到订单实例
	 * 
	 * @param bid
	 * @param cid
	 * @param total_price
	 * @param time
	 * @param state
	 */
	public Order(int bid, int cid, double total_price, Date time, String state) {
		setBid(bid);
		setCid(cid);
		setTotal_price(total_price);
		setTime(time);
		setState(state);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
