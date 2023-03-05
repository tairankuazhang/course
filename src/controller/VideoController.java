package controller;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Comments;
import pojo.Levels;
import pojo.Question;
import pojo.Video;
import pojo.VideoConnection;
import service.VideoService;
import tools.Tools;


@Controller

@RequestMapping("/video")
public class VideoController {

	@Autowired(required=false)
	VideoService videoService;
	
	@RequestMapping("/details")
	public ModelAndView details(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();
		String strvid = request.getParameter("vid");
		int vid=Integer.parseInt(strvid);
		int i=videoService.plusViews(vid);
		if(i==1){
			Video video=videoService.selectVideoById(vid);
			mav.addObject("video", video);
			String strscore=videoService.avgScore(vid);
			DecimalFormat df= new DecimalFormat("######0.00");
			double score=0;
			if(strscore!=null){
				score=Double.parseDouble(strscore);
				strscore=df.format(score);
			}
			mav.addObject("score", strscore);
			List<Comments> com=videoService.selectCommentsByVid(vid);
			mav.addObject("comments", com);
			List<VideoConnection> vc=videoService.selectVideoConnectionByVid(vid);
			mav.addObject("vc", vc);
			List<Question> question=videoService.selectQuestionByVid(vid);
			mav.addObject("question", question);
			mav.setViewName("video/details");
		}else{
			Tools.prompt(response, "出现错误，请重新操作", "../student/home");
		}
		return mav;
	}
	
	@RequestMapping("/userScore")
	public ModelAndView userScore(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		ModelAndView mav = new ModelAndView();
		String strvid = request.getParameter("vid");
		String strscore = request.getParameter("score");
		double score=Double.parseDouble(strscore);
		int vid=Integer.parseInt(strvid);
		int userid=(int) session.getAttribute("userid");
		Levels levels=new Levels();
		levels.setL_score(score);
		levels.setL_vid(vid);
		levels.setL_sid(userid);
		int i=videoService.userScore(levels);
		if(i==1){
			Tools.prompt(response, "评分成功", "../video/details?vid="+vid);
		}else{
			Tools.prompt(response, "出现错误,请重新操作", "../video/details?vid="+vid);
		}
		mav.setViewName("video/details");
		return mav;
	}
	
	@RequestMapping("/userComment")
	public ModelAndView userComment(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		ModelAndView mav = new ModelAndView();
		String strvid = request.getParameter("vid");
		String context = new String(request.getParameter("context").getBytes("iso-8859-1"), "utf-8");
		int vid=Integer.parseInt(strvid);
		int userid=(int) session.getAttribute("userid");
		Comments comments=new Comments();
		comments.setCo_content(context);
		comments.setCo_vid(vid);
		comments.setCo_sid(userid);
		int i=videoService.userComment(comments);
		if(i==1){
			Tools.prompt(response, "评论成功", "../video/details?vid="+vid);
		}else{
			Tools.prompt(response, "出现错误,请重新操作", "../video/details?vid="+vid);
		}
		mav.setViewName("video/details");
		return mav;
	}
	
	@RequestMapping(value = "/insert")
	public ModelAndView insertVideo(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String[] information=Tools.MoveFiles(request, 4,"image");
		Video video=new Video();
		video.setV_name(information[0]);
		video.setV_tyid(Integer.parseInt(information[1]));
		video.setV_pic(information[2]);
		video.setV_intro(information[3]);
		video.setV_teid((int)session.getAttribute("userid"));
		
		int i=videoService.insertVideo(video);
		if(i==1){
			Tools.prompt(response, "添加成功", "../teacher/selectVideoByTeid");
		}else{
			Tools.prompt(response, "添加失败，请重新操作", "../teacher/selectVideoByTeid");
		}
		return mav;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView updateVideo(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String[] information=Tools.MoveFiles(request, 5,"image");
		String pic = videoService.selectVideoPicById(Integer.parseInt(information[4]));
		Video video=new Video();
		video.setV_name(information[0]);
		video.setV_tyid(Integer.parseInt(information[1]));
		if("".equals(information[2])){
			video.setV_pic(pic);
		}else{
			Tools.DeleteFile(1, pic);
			video.setV_pic(information[2]);
		}
		video.setV_intro(information[3]);
		video.setV_id(Integer.parseInt(information[4]));
		
		int i=videoService.updateVideo(video);
		if(i==1){
			Tools.prompt(response, "修改成功", "../teacher/selectVideoByTeid");
		}else{
			Tools.prompt(response, "修改失败，请重新操作", "../teacher/selectVideoByTeid");
		}
		return mav;
	}
}
