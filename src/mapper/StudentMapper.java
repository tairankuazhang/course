package mapper;

import java.util.List;






import pojo.Cclass;
import pojo.Notes;
import pojo.Student;
import pojo.Video;
import pojo.VideoType;

public interface StudentMapper {

	public List<Video> selectTypeVideo();
	public List<Video> selectVideoSort();
	public List<VideoType> selectType();
	public List<Cclass> selectClassById(int id);
	public List<Notes> selectNotesById(int id);
	public int updateStudent(Student student);
}
