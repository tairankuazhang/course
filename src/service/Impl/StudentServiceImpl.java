package service.Impl;

import java.util.List;

import mapper.StudentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Cclass;
import pojo.Notes;
import pojo.Student;
import pojo.Video;
import pojo.VideoType;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;

	@Override
	public List<Video> selectTypeVideo() {
		// TODO Auto-generated method stub
		return studentMapper.selectTypeVideo();
	}

	@Override
	public List<Video> selectVideoSort() {
		// TODO Auto-generated method stub
		return studentMapper.selectVideoSort();
	}

	@Override
	public List<VideoType> selectType() {
		// TODO Auto-generated method stub
		return studentMapper.selectType();
	}

	@Override
	public List<Cclass> selectClassById(int id) {
		// TODO Auto-generated method stub
		return studentMapper.selectClassById(id);
	}
	
	@Override
	public List<Notes> selectNotesById(int id) {
		// TODO Auto-generated method stub
		return studentMapper.selectNotesById(id);
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.updateStudent(student);
	}
}
