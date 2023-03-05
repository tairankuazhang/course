package service;

import java.util.List;

import pojo.Cclass;
import pojo.Question;
import pojo.Teacher;
import pojo.Video;
import pojo.VideoConnection;
import pojo.VideoType;

public interface TeacherService {
	public List<Cclass> selectClassByTeid(int userid);
	public List<Question> selectQuestionByTeid(int userid);
	public List<Video> selectVideoByTeid(int userid);
	public List<VideoType> selectType();
	public List<VideoConnection> selectConnectionByid(int id);
	public int insertConnection(VideoConnection connection);
	public int deleteConnectionByid(int id);
	public int updateTeacher(Teacher teacher);
}
