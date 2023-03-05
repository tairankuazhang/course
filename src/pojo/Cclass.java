package pojo;

public class Cclass {
	private int cl_id;
	private String cl_name;
	private int cl_tid;
	private int cl_vid;
	private String te_name;
	private String v_name;
	private int cs_id;
	public Cclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cclass(int cl_id, String cl_name, int cl_tid, int cl_vid,
			String te_name, String v_name, int cs_id) {
		super();
		this.cl_id = cl_id;
		this.cl_name = cl_name;
		this.cl_tid = cl_tid;
		this.cl_vid = cl_vid;
		this.te_name = te_name;
		this.v_name = v_name;
		this.cs_id = cs_id;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	public int getCl_tid() {
		return cl_tid;
	}
	public void setCl_tid(int cl_tid) {
		this.cl_tid = cl_tid;
	}
	public int getCl_vid() {
		return cl_vid;
	}
	public void setCl_vid(int cl_vid) {
		this.cl_vid = cl_vid;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public int getCs_id() {
		return cs_id;
	}
	public void setCs_id(int cs_id) {
		this.cs_id = cs_id;
	}
	@Override
	public String toString() {
		return "Cclass [cl_id=" + cl_id + ", cl_name=" + cl_name + ", cl_tid="
				+ cl_tid + ", cl_vid=" + cl_vid + ", te_name=" + te_name
				+ ", v_name=" + v_name + ", cs_id=" + cs_id + "]";
	}
	
	
}
