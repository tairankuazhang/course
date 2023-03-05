package service;

import pojo.Cclass;

public interface ClassService {
	public int insertClass(Cclass cclass);
	public int updateClass(Cclass cclass);
	public Cclass searchResult(int id);
	public int insertClassStudent(int cid,int sid);
	public int deleteClassStudent(int csid);
}
