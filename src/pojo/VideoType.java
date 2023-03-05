package pojo;

public class VideoType {
	private int ty_id;
	private String ty_name;
	public VideoType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoType(int ty_id, String ty_name) {
		super();
		this.ty_id = ty_id;
		this.ty_name = ty_name;
	}
	public int getTy_id() {
		return ty_id;
	}
	public void setTy_id(int ty_id) {
		this.ty_id = ty_id;
	}
	public String getTy_name() {
		return ty_name;
	}
	public void setTy_name(String ty_name) {
		this.ty_name = ty_name;
	}
	@Override
	public String toString() {
		return "Type [ty_id=" + ty_id + ", ty_name=" + ty_name + "]";
	}
	
}
