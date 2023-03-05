package service.Impl;
import mapper.QuestionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Question;
import service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionMapper questionMapper;

	@Override
	public int insertQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionMapper.insertQuestion(question);
	}

	@Override
	public int updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionMapper.updateQuestion(question);
	}
}
