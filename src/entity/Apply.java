package entity;

import java.util.Date;

public class Apply {

	private int id;
	private String content;
	private int bid;
	private Date time;
	private String state;

	/**
	 * 新增申请
	 * 
	 * @param bid
	 * @param content
	 */
	public Apply(int bid, String content) {
		setBid(bid);
		setContent(content);
	}

	/**
	 * 得到申请实例
	 * 
	 * @param content
	 * @param bid
	 * @param time
	 * @param state
	 */
	public Apply(int bid, String content, Date time, String state) {
		setContent(content);
		setBid(bid);
		setTime(time);
		setState(state);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
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
