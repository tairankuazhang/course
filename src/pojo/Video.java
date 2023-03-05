package pojo;

public class Video {
	private int v_id;
	private String v_name;
	private int v_teid;
	private String te_name;
	private int v_tyid;
	private String ty_name;
	private String v_pic;
	private String v_address;
	private String v_intro;
	private int v_views;
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Video(int v_id, String v_name, int v_teid, String te_name,
			int v_tyid, String ty_name, String v_pic, String v_address,
			String v_intro, int v_views) {
		super();
		this.v_id = v_id;
		this.v_name = v_name;
		this.v_teid = v_teid;
		this.te_name = te_name;
		this.v_tyid = v_tyid;
		this.ty_name = ty_name;
		this.v_pic = v_pic;
		this.v_address = v_address;
		this.v_intro = v_intro;
		this.v_views = v_views;
	}
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public int getV_teid() {
		return v_teid;
	}
	public void setV_teid(int v_teid) {
		this.v_teid = v_teid;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	public int getV_tyid() {
		return v_tyid;
	}
	public void setV_tyid(int v_tyid) {
		this.v_tyid = v_tyid;
	}
	public String getTy_name() {
		return ty_name;
	}
	public void setTy_name(String ty_name) {
		this.ty_name = ty_name;
	}
	public String getV_pic() {
		return v_pic;
	}
	public void setV_pic(String v_pic) {
		this.v_pic = v_pic;
	}
	public String getV_address() {
		return v_address;
	}
	public void setV_address(String v_address) {
		this.v_address = v_address;
	}
	public String getV_intro() {
		return v_intro;
	}
	public void setV_intro(String v_intro) {
		this.v_intro = v_intro;
	}
	public int getV_views() {
		return v_views;
	}
	public void setV_views(int v_views) {
		this.v_views = v_views;
	}
	@Override
	public String toString() {
		return "Video [v_id=" + v_id + ", v_name=" + v_name + ", v_teid="
				+ v_teid + ", te_name=" + te_name + ", v_tyid=" + v_tyid
				+ ", ty_name=" + ty_name + ", v_pic=" + v_pic + ", v_address="
				+ v_address + ", v_intro=" + v_intro + ", v_views=" + v_views
				+ "]";
	}
	
}
