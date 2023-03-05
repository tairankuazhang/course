package service.Impl;


import java.util.List;

import mapper.IndexMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Cclass;
import pojo.Student;
import pojo.Teacher;
import pojo.Video;
import service.IndexService;

@Service
public class IndexServiceImpl implements IndexService{

	@Autowired
	IndexMapper indexMapper;

	@Override
	public Student findStudent(String name) {
		Student pass = indexMapper.findStudent(name);
		return pass;
	}

	@Override
	public String findAdmin(String name) {
		String pass = indexMapper.findAdmin(name);
		return pass;
	}

	@Override
	public Teacher findTeacher(String name) {
		Teacher pass = indexMapper.findTeacher(name);
		return pass;
	}

	@Override
	public int addStudent(Student stu) {
		
		return indexMapper.addStudent(stu);
	}

	@Override
	public int addTeacher(Teacher tea) {
		// TODO Auto-generated method stub
		return indexMapper.addTeacher(tea);
	}

	@Override
	public List<Video> selectVideoByTypeId(int id) {
		// TODO Auto-generated method stub
		return indexMapper.selectVideoByTypeId(id);
	}

	@Override
	public Student selectStudentById(int id) {
		// TODO Auto-generated method stub
		return indexMapper.selectStudentById(id);
	}

	@Override
	public Teacher selectTeacherById(int id) {
		// TODO Auto-generated method stub
		return indexMapper.selectTeacherById(id);
	}

	@Override
	public List<Student> selectStudentByName(String name) {
		// TODO Auto-generated method stub
		return indexMapper.selectStudentByName(name);
	}

	@Override
	public List<Teacher> selectTeacherByName(String name) {
		// TODO Auto-generated method stub
		return indexMapper.selectTeacherByName(name);
	}

	@Override
	public List<Cclass> selectClassByName(String name) {
		// TODO Auto-generated method stub
		return indexMapper.selectClassByName(name);
	}

	@Override
	public List<Video> selectVideoByName(String name) {
		// TODO Auto-generated method stub
		return indexMapper.selectVideoByName(name);
	}
	
}
