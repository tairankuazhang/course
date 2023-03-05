package pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Levels {
	private int l_id;
	private double l_score;
	private int l_sid;
	private String s_name;
	private int l_vid;
	private String v_name;
	private Date l_time;
	
	public Levels() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Levels(int l_id, double l_score, int l_sid, String s_name,
			int l_vid, String v_name, Date l_time) {
		super();
		this.l_id = l_id;
		this.l_score = l_score;
		this.l_sid = l_sid;
		this.s_name = s_name;
		this.l_vid = l_vid;
		this.v_name = v_name;
		this.l_time = l_time;
	}
	
	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public double getL_score() {
		return l_score;
	}

	public void setL_score(double l_score) {
		this.l_score = l_score;
	}

	public int getL_sid() {
		return l_sid;
	}

	public void setL_sid(int l_sid) {
		this.l_sid = l_sid;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getL_vid() {
		return l_vid;
	}

	public void setL_vid(int l_vid) {
		this.l_vid = l_vid;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public String geltL_time() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(l_time);
		return dateString;
	}

	public void setL_time(Date l_time) {
		this.l_time = l_time;
	}
	
	@Override
	public String toString() {
		return "Levels [l_id=" + l_id + ", l_score=" + l_score + ", l_sid="
				+ l_sid + ", s_name=" + s_name + ", l_vid=" + l_vid
				+ ", v_name=" + v_name + ", l_time=" + l_time + "]";
	}
	
}
