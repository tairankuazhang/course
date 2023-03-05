package service.Impl;

import mapper.ClassMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Cclass;
import service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	ClassMapper classMapper;

	@Override
	public int insertClass(Cclass cclass) {
		// TODO Auto-generated method stub
		return classMapper.insertClass(cclass);
	}

	@Override
	public int updateClass(Cclass cclass) {
		// TODO Auto-generated method stub
		return classMapper.updateClass(cclass);
	}

	@Override
	public Cclass searchResult(int id) {
		// TODO Auto-generated method stub
		return classMapper.searchResult(id);
	}

	@Override
	public int insertClassStudent(int cid, int sid) {
		// TODO Auto-generated method stub
		return classMapper.insertClassStudent(cid,sid);
	}

	@Override
	public int deleteClassStudent(int csid) {
		// TODO Auto-generated method stub
		return classMapper.deleteClassStudent(csid);
	}
}
