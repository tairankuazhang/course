package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Cclass;
import pojo.Student;
import pojo.Teacher;
import pojo.Video;

public interface IndexMapper {
	public Student findStudent(@Param("name") String name);
	public String findAdmin(@Param("name") String name);
	public Teacher findTeacher(@Param("name") String name);
	public int addStudent(Student stu);
	public int addTeacher(Teacher tea);
	public List<Video> selectVideoByTypeId(int id);
	public Student selectStudentById(int id);
	public Teacher selectTeacherById(int id);
	public List<Student> selectStudentByName(@Param("name") String name);
	public List<Teacher> selectTeacherByName(@Param("name") String name);
	public List<Cclass> selectClassByName(@Param("name") String name);
	public List<Video> selectVideoByName(@Param("name") String name);
}
