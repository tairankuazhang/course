package service.Impl;

import java.util.List;

import mapper.VideoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Comments;
import pojo.Levels;
import pojo.Question;
import pojo.Video;
import pojo.VideoConnection;
import service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoMapper videoMapper;

	@Override
	public Video selectVideoById(int id) {
		// TODO Auto-generated method stub
		return videoMapper.selectVideoById(id);
	}

	@Override
	public String avgScore(int id) {
		// TODO Auto-generated method stub
		return videoMapper.avgScore(id);
	}

	@Override
	public List<Comments> selectCommentsByVid(int id) {
		// TODO Auto-generated method stub
		return videoMapper.selectCommentsByVid(id);
	}

	@Override
	public int userScore(Levels levels) {
		// TODO Auto-generated method stub
		return videoMapper.userScore(levels);
	}

	@Override
	public int userComment(Comments comments) {
		// TODO Auto-generated method stub
		return videoMapper.userComment(comments);
	}

	public int insertVideo(Video video) {
		// TODO Auto-generated method stub
		return videoMapper.insertVideo(video);
	}

	@Override
	public int updateVideo(Video video) {
		// TODO Auto-generated method stub
		return videoMapper.updateVideo(video);
	}

	@Override
	public int plusViews(int vid) {
		// TODO Auto-generated method stub
		return videoMapper.plusViews(vid);
	}

	@Override
	public String selectVideoPicById(int vid) {
		// TODO Auto-generated method stub
		return videoMapper.selectVideoPicById(vid);
	}

	@Override
	public List<VideoConnection> selectVideoConnectionByVid(int vid) {
		// TODO Auto-generated method stub
		return videoMapper.selectVideoConnectionByVid(vid);
	}

	@Override
	public List<Question> selectQuestionByVid(int vid) {
		// TODO Auto-generated method stub
		return videoMapper.selectQuestionByVid(vid);
	}
}
