package service;

import java.util.List;

import pojo.Cclass;
import pojo.Comments;
import pojo.Notes;
import pojo.Question;
import pojo.Student;
import pojo.Teacher;
import pojo.Video;

public interface AdminService {
	public List<Student> selectStudent();
	public List<Teacher> selectTeacher();
	public List<Comments> selectComments();
	public List<Video> selectVideo();
	public List<Notes> selectNotes();
	public List<Question> selectQuestion();
	public List<Cclass> selectClass();
	public void deleteClass(int id);
	public void deleteComments(int id);
	public void deleteNotes(int id);
	public void deleteQuestion(int id);
	public void deleteTeacher(int id);
	public void deleteStudent(int id);
	public void deleteVideo(int id);
}
