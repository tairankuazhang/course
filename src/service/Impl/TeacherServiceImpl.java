package service.Impl;

import java.util.List;

import mapper.TeacherMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Cclass;
import pojo.Question;
import pojo.Teacher;
import pojo.Video;
import pojo.VideoConnection;
import pojo.VideoType;
import service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherMapper teacherMapper;

	@Override
	public List<Cclass> selectClassByTeid(int userid) {
		// TODO Auto-generated method stub
		return teacherMapper.selectClassByTeid(userid);
	}

	@Override
	public List<Question> selectQuestionByTeid(int userid) {
		// TODO Auto-generated method stub
		return teacherMapper.selectQuestionByTeid(userid);
	}

	@Override
	public List<Video> selectVideoByTeid(int userid) {
		// TODO Auto-generated method stub
		return teacherMapper.selectVideoByTeid(userid);
	}

	public List<VideoType> selectType() {
		// TODO Auto-generated method stub
		return teacherMapper.selectType();
	}

	@Override
	public List<VideoConnection> selectConnectionByid(int id) {
		// TODO Auto-generated method stub
		return teacherMapper.selectConnectionByid(id);
	}

	@Override
	public int insertConnection(VideoConnection connection) {
		// TODO Auto-generated method stub
		return teacherMapper.insertConnection(connection);
	}

	@Override
	public int deleteConnectionByid(int id) {
		// TODO Auto-generated method stub
		return teacherMapper.deleteConnectionByid(id);
	}

	@Override
	public int updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherMapper.updateTeacher(teacher);
	}
}
