package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.Cclass;
import pojo.Question;
import pojo.Teacher;
import pojo.Video;
import pojo.VideoConnection;
import pojo.VideoType;
import service.TeacherService;
import tools.Tools;


@Controller

@RequestMapping("/teacher")
public class TeacherController {

	@Autowired(required=false)
	TeacherService teacherService;
	
	@RequestMapping("/selectClassByTeid")
	public ModelAndView selectClassByTeid(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int userid=(int)session.getAttribute("userid");
		List<Video> video=teacherService.selectVideoByTeid(userid);
		mav.addObject("video", video);
		List<Cclass> cclass=teacherService.selectClassByTeid(userid);
		mav.addObject("cclass", cclass);
		mav.setViewName("cclass/index");
		return mav;
	}
	
	@RequestMapping("/selectQuestionByTeid")
	public ModelAndView selectQuestionByTeid(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int userid=(int)session.getAttribute("userid");
		List<Video> video=teacherService.selectVideoByTeid(userid);
		mav.addObject("video", video);
		List<Question> question=teacherService.selectQuestionByTeid(userid);
		mav.addObject("question", question);
		mav.setViewName("question/index");
		return mav;
	}
	
	@RequestMapping("/selectVideoByTeid")
	public ModelAndView selectVideoByTeid(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int userid=(int)session.getAttribute("userid");
		List<VideoType> listType=teacherService.selectType();
		mav.addObject("listType",listType);
		List<Video> video=teacherService.selectVideoByTeid(userid);
		mav.addObject("video", video);
		mav.setViewName("video/index");
		return mav;
	}
	
	@RequestMapping("/selectConnectionByid")
	public ModelAndView selectConnectionByid(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String idString = request.getParameter("id");
		int id=Integer.parseInt(idString);
		List<VideoConnection> listConnection=teacherService.selectConnectionByid(id);
		mav.addObject("listConnection",listConnection);
		mav.addObject("connectionId", id);
		mav.setViewName("video/connection");
		return mav;
	}
	
	@RequestMapping(value="/insertConnection",method = RequestMethod.POST)
	public ModelAndView insertConnection(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		ModelAndView mav = new ModelAndView();
		String[] information=Tools.MoveFiles(request, 3, "videos");
		String name=information[0];
		int id=Integer.parseInt(information[1]);
		String address=information[2];
		VideoConnection connection=new VideoConnection();
		connection.setVc_name(name);
		connection.setVc_vid(id);
		connection.setVc_address(address);
		int i=teacherService.insertConnection(connection);
		if(i==1){
			Tools.prompt(response, "添加成功", "./selectConnectionByid?id="+id);
		}
		else{
			Tools.prompt(response, "添加失败,请重新添加", "./selectConnectionByid?id="+id);
		}
		return mav;
	}
	
	@RequestMapping("/deleteConnectionByid")
	public ModelAndView deleteConnectionByid(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		ModelAndView mav = new ModelAndView();
		String vcidString = request.getParameter("id");
		int vcid=Integer.parseInt(vcidString);
		String idString = request.getParameter("vid");
		int id=Integer.parseInt(idString);
		int i=teacherService.deleteConnectionByid(vcid);
		if(i==1){
			Tools.prompt(response, "删除成功", "./selectConnectionByid?id="+id);
		}
		else{
			Tools.prompt(response, "删除失败,请重新添加", "./selectConnectionByid?id="+id);
		}
		return mav;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public ModelAndView updateTeacher(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		ModelAndView mav = new ModelAndView();
		String tidString = request.getParameter("tid");
		int tid=Integer.parseInt(tidString);
		String[] information=Tools.MoveFiles(request, 5, "image");
		Teacher teacher=new Teacher();
		teacher.setTe_id(tid);
		teacher.setTe_name(information[0]);
		teacher.setTe_password(information[1]);
		teacher.setTe_gender(information[2]);
		teacher.setTe_intro(information[3]);
		teacher.setTe_pic(information[4]);
		int i=teacherService.updateTeacher(teacher);
		if(i==1){
			Tools.prompt(response, "修改成功", "../user/userDetails");
		}
		else{
			Tools.prompt(response, "修改失败,请重新操作", "../user/userDetails");
		}
		return mav;
	}
}
