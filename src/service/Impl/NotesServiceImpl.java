package service.Impl;

import mapper.NotesMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Notes;
import service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	NotesMapper notesMapper;

	@Override
	public int insertNotes(Notes notes) {
		// TODO Auto-generated method stub
		return notesMapper.insertNotes(notes);
	}

	@Override
	public int updateNotes(Notes notes) {
		// TODO Auto-generated method stub
		return notesMapper.updateNotes(notes);
	}
}
