package pojo;

public class Student {

	private int s_id;
	private String s_name;
	private String s_password;
	private String s_gender;
	private String s_pic;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int s_id, String s_name, String s_password, String s_gender,
			String s_pic) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_password = s_password;
		this.s_gender = s_gender;
		this.s_pic = s_pic;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_password() {
		return s_password;
	}
	public void setS_password(String s_password) {
		this.s_password = s_password;
	}
	public String getS_gender() {
		return s_gender;
	}
	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	public String getS_pic() {
		return s_pic;
	}
	public void setS_pic(String s_pic) {
		this.s_pic = s_pic;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_password="
				+ s_password + ", s_gender=" + s_gender + ", s_pic=" + s_pic
				+ "]";
	}
	
	
}
