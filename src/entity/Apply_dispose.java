package entity;

import java.util.Date;

public class Apply_dispose {

	private int id;
	private String content;
	private int aid;
	private int mid;
	private Date time;
	
	/**
	 * 新增申请反馈
	 * @param aid
	 * @param mid
	 * @param content
	 */
	public Apply_dispose(int aid,int mid,String content){
		setAid(aid);
		setMid(mid);
		setContent(content);
	}

	/**
	 * 得到申请反馈实例
	 * 
	 * @param bid
	 * @param mid
	 * @param content
	 * @param time
	 */
	public Apply_dispose(int aid, int mid, String content, Date time) {
		setAid(aid);
		setMid(mid);
		setContent(content);
		setTime(time);
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

	public int getAid() {
		return aid;
	}

	public void setAid(int bid) {
		this.aid = bid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
