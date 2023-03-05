package service.Impl;

import java.util.List;

import mapper.AdminMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Cclass;
import pojo.Comments;
import pojo.Notes;
import pojo.Question;
import pojo.Student;
import pojo.Teacher;
import pojo.Video;
import service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;

	@Override
	public List<Student> selectStudent() {
		List<Student> stu = adminMapper.selectStudent();
		return stu;
	}

	@Override
	public List<Teacher> selectTeacher() {
		List<Teacher> tea = adminMapper.selectTeacher();
		return tea;
	}

	@Override
	public List<Comments> selectComments() {
		List<Comments> com = adminMapper.selectComments();
		return com;
	}

	@Override
	public List<Video> selectVideo() {
		List<Video> vid = adminMapper.selectVideo();
		return vid;
	}

	@Override
	public List<Notes> selectNotes() {
		List<Notes> not = adminMapper.selectNotes();
		return not;
	}

	@Override
	public List<Question> selectQuestion() {
		List<Question> que = adminMapper.selectQuestion();
		return que;
	}

	@Override
	public List<Cclass> selectClass() {
		List<Cclass> cla = adminMapper.selectClass();
		return cla;
	}

	@Override
	public void deleteClass(int id) {
		adminMapper.deleteClass(id);
		
	}

	@Override
	public void deleteComments(int id) {
		// TODO Auto-generated method stub
		adminMapper.deleteComments(id);
	}

	@Override
	public void deleteNotes(int id) {
		// TODO Auto-generated method stub
		adminMapper.deleteNotes(id);
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		adminMapper.deleteQuestion(id);
	}

	@Override
	public void deleteTeacher(int id) {
		// TODO Auto-generated method stub
		adminMapper.deleteTeacher(id);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		adminMapper.deleteStudent(id);
	}

	@Override
	public void deleteVideo(int id) {
		// TODO Auto-generated method stub
		adminMapper.deleteVideo(id);
	}
}
