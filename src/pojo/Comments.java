package pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comments {
	private int co_id;
	private String co_content;
	private int co_sid;
	private String s_name;
	private int co_vid;
	private String v_name;
	private Date co_time;
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(int co_id, String co_content, int co_sid, String s_name,
			int co_vid, String v_name, Date co_time) {
		super();
		this.co_id = co_id;
		this.co_content = co_content;
		this.co_sid = co_sid;
		this.s_name = s_name;
		this.co_vid = co_vid;
		this.v_name = v_name;
		this.co_time = co_time;
	}
	public int getCo_id() {
		return co_id;
	}
	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}
	public String getCo_content() {
		return co_content;
	}
	public void setCo_content(String co_content) {
		this.co_content = co_content;
	}
	public int getCo_sid() {
		return co_sid;
	}
	public void setCo_sid(int co_sid) {
		this.co_sid = co_sid;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getCo_vid() {
		return co_vid;
	}
	public void setCo_vid(int co_vid) {
		this.co_vid = co_vid;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getCo_time() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(co_time);
		return dateString;
	}
	public void setCo_time(Date co_time) {
		this.co_time = co_time;
	}
	@Override
	public String toString() {
		return "Comments [co_id=" + co_id + ", co_content=" + co_content
				+ ", co_sid=" + co_sid + ", s_name=" + s_name + ", co_vid="
				+ co_vid + ", v_name=" + v_name + ", co_time=" + co_time + "]";
	}
	
}
