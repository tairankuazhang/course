package service;

import java.util.List;

import pojo.Cclass;
import pojo.Notes;
import pojo.Student;
import pojo.Teacher;
import pojo.VideoType;
import pojo.Video;

public interface StudentService {
	
	public List<Video> selectTypeVideo();
	public List<Video> selectVideoSort();
	public List<VideoType> selectType();
	public List<Cclass> selectClassById(int id);
	public List<Notes> selectNotesById(int id);
	public int updateStudent(Student student);
}
