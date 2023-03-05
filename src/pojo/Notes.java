package pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notes {
	private int n_id;
	private String n_content;
	private int n_sid;
	private Date n_time;
	private String s_name;
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notes(int n_id, String n_content, int n_sid, Date n_time,
			String s_name) {
		super();
		this.n_id = n_id;
		this.n_content = n_content;
		this.n_sid = n_sid;
		this.n_time = n_time;
		this.s_name = s_name;
	}
	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public int getN_sid() {
		return n_sid;
	}
	public void setN_sid(int n_sid) {
		this.n_sid = n_sid;
	}
	public String getN_time() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(n_time);
		return dateString;
	}
	public void setN_time(Date n_time) {
		this.n_time = n_time;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	@Override
	public String toString() {
		return "Notes [n_id=" + n_id + ", n_content=" + n_content + ", n_sid="
				+ n_sid + ", n_time=" + n_time + ", s_name=" + s_name + "]";
	}
	
}
