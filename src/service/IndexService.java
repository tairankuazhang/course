package service;

import java.util.List;

import pojo.Cclass;
import pojo.Student;
import pojo.Teacher;
import pojo.Video;

public interface IndexService {
	public Student findStudent(String name);
	public String findAdmin(String name);
	public Teacher findTeacher(String name);
	public int addStudent(Student stu);
	public int addTeacher(Teacher tea);
	public List<Video> selectVideoByTypeId(int id);
	public Student selectStudentById(int id);
	public Teacher selectTeacherById(int id);
	public List<Student> selectStudentByName(String name);
	public List<Teacher> selectTeacherByName(String name);
	public List<Cclass> selectClassByName(String name);
	public List<Video> selectVideoByName(String name);
}
