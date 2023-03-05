package pojo;

public class VideoConnection {
	private int vc_id;
	private String vc_name;
	private String vc_address;
	private int vc_vid;
	private String v_name;
	public VideoConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoConnection(int vc_id, String vc_name, String vc_address,
			int vc_vid, String v_name) {
		super();
		this.vc_id = vc_id;
		this.vc_name = vc_name;
		this.vc_address = vc_address;
		this.vc_vid = vc_vid;
		this.v_name = v_name;
	}
	public int getVc_id() {
		return vc_id;
	}
	public void setVc_id(int vc_id) {
		this.vc_id = vc_id;
	}
	public String getVc_name() {
		return vc_name;
	}
	public void setVc_name(String vc_name) {
		this.vc_name = vc_name;
	}
	public String getVc_address() {
		return vc_address;
	}
	public void setVc_address(String vc_address) {
		this.vc_address = vc_address;
	}
	public int getVc_vid() {
		return vc_vid;
	}
	public void setVc_vid(int vc_vid) {
		this.vc_vid = vc_vid;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	@Override
	public String toString() {
		return "VideoConnection [vc_id=" + vc_id + ", vc_name=" + vc_name
				+ ", vc_address=" + vc_address + ", vc_vid=" + vc_vid
				+ ", v_name=" + v_name + "]";
	}
	
}
