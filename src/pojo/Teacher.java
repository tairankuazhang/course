package pojo;

public class Teacher {
	private int te_id;
	private String te_name;
	private String te_password;
	private String te_gender;
	private String te_intro;
	private String te_pic;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int te_id, String te_name, String te_password,
			String te_gender, String te_intro, String te_pic) {
		super();
		this.te_id = te_id;
		this.te_name = te_name;
		this.te_password = te_password;
		this.te_gender = te_gender;
		this.te_intro = te_intro;
		this.te_pic = te_pic;
	}
	public int getTe_id() {
		return te_id;
	}
	public void setTe_id(int te_id) {
		this.te_id = te_id;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	public String getTe_password() {
		return te_password;
	}
	public void setTe_password(String te_password) {
		this.te_password = te_password;
	}
	public String getTe_gender() {
		return te_gender;
	}
	public void setTe_gender(String te_gender) {
		this.te_gender = te_gender;
	}
	public String getTe_intro() {
		return te_intro;
	}
	public void setTe_intro(String te_intro) {
		this.te_intro = te_intro;
	}
	public String getTe_pic() {
		return te_pic;
	}
	public void setTe_pic(String te_pic) {
		this.te_pic = te_pic;
	}
	@Override
	public String toString() {
		return "Teacher [te_id=" + te_id + ", te_name=" + te_name
				+ ", te_password=" + te_password + ", te_gender=" + te_gender
				+ ", te_intro=" + te_intro + ", te_pic=" + te_pic + "]";
	}
	
}
