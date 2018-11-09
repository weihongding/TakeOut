package entity;

import java.util.Date;

public class Complain {

	private int id;
	private int cid;
	private String content;
	private Date time;
	private String state;

	/**
	 * 新增投诉建议
	 * 
	 * @param cid
	 * @param content
	 */
	public Complain(int cid, String content) {
		setCid(cid);
		setContent(content);
	}

	/**
	 * 得到投诉建议实例
	 * 
	 * @param cid
	 * @param content
	 * @param time
	 * @param state
	 */
	public Complain(int cid, String content, Date time, String state) {
		setCid(cid);
		setContent(content);
		setTime(time);
		setState(state);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
