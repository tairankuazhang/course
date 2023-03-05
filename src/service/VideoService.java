package service;

import java.util.List;

import pojo.Comments;
import pojo.Levels;
import pojo.Question;
import pojo.Video;
import pojo.VideoConnection;

public interface VideoService {
	public Video selectVideoById(int id);
	public String avgScore(int id);
	public List<Comments> selectCommentsByVid(int id);
	public int userScore(Levels levels);
	public int userComment(Comments comments);
	public int insertVideo(Video video);
	public int updateVideo(Video video);
	public int plusViews(int vid);
	public String selectVideoPicById(int vid);
	public List<VideoConnection> selectVideoConnectionByVid(int vid);
	public List<Question> selectQuestionByVid(int vid);
}
