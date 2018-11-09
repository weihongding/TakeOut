package entity;

import java.util.Date;

public class Complain_dispose {

	private int id;
	private int coid;
	private int mid;
	private String content;
	private Date time;

	/**
	 * ����Ͷ�߽��鷴��
	 * 
	 * @param coid
	 * @param mid
	 * @param content
	 */
	public Complain_dispose(int coid, int mid, String content) {
		setCoid(coid);
		setMid(mid);
		setContent(content);
	}

	/**
	 * �õ�Ͷ�߽��鷴��ʵ��
	 * 
	 * @param coid
	 * @param mid
	 * @param content
	 * @param time
	 */
	public Complain_dispose(int coid, int mid, String content, Date time) {
		setCoid(coid);
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

	public int getCoid() {
		return coid;
	}

	public void setCoid(int coid) {
		this.coid = coid;
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

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

}
