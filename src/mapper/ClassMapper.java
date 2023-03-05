package mapper;

import org.apache.ibatis.annotations.Param;

import pojo.Cclass;

public interface ClassMapper {
	public int insertClass(Cclass cclass);
	public int updateClass(Cclass cclass);
	public Cclass searchResult(int id);
	public int insertClassStudent(@Param("cid") int cid,@Param("sid") int sid);
	public int deleteClassStudent(int csid);
}
