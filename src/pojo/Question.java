package pojo;

public class Question {
	private int q_id;
	private String q_topic;
	private String q_answer;
	private int q_vid;
	private String v_name;
	private int q_tid;
	private String te_name;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int q_id, String q_topic, String q_answer, int q_vid,
			String v_name, int q_tid, String te_name) {
		super();
		this.q_id = q_id;
		this.q_topic = q_topic;
		this.q_answer = q_answer;
		this.q_vid = q_vid;
		this.v_name = v_name;
		this.q_tid = q_tid;
		this.te_name = te_name;
	}
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public String getQ_topic() {
		return q_topic;
	}
	public void setQ_topic(String q_topic) {
		this.q_topic = q_topic;
	}
	public String getQ_answer() {
		return q_answer;
	}
	public void setQ_answer(String q_answer) {
		this.q_answer = q_answer;
	}
	public int getQ_vid() {
		return q_vid;
	}
	public void setQ_vid(int q_vid) {
		this.q_vid = q_vid;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public int getQ_tid() {
		return q_tid;
	}
	public void setQ_tid(int q_tid) {
		this.q_tid = q_tid;
	}
	public String getTe_name() {
		return te_name;
	}
	public void setTe_name(String te_name) {
		this.te_name = te_name;
	}
	@Override
	public String toString() {
		return "Question [q_id=" + q_id + ", q_topic=" + q_topic
				+ ", q_answer=" + q_answer + ", q_vid=" + q_vid + ", v_name="
				+ v_name + ", q_tid=" + q_tid + ", te_name=" + te_name + "]";
	}
	
}
