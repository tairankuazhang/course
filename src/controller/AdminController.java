package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Cclass;
import pojo.Comments;
import pojo.Notes;
import pojo.Question;
import pojo.Student;
import pojo.Teacher;
import pojo.Video;
import service.AdminService;
import tools.Tools;

@Controller

@RequestMapping("/admin")
public class AdminController {
	@Autowired(required=false)
	AdminService adminService;
	
	@RequestMapping(value = "/index")
	public String index(){
		return "admin/index";
	}
	
	@RequestMapping(value = "/selectStudent")
	public ModelAndView selectStudent(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		List<Student> stu=adminService.selectStudent();
		mav.addObject("student", stu);
		mav.setViewName("admin/adminSelect");
		return mav;
	}
	
	@RequestMapping(value = "/selectTeacher")
	public ModelAndView selectTeacher(){
		ModelAndView mav=new ModelAndView();
		List<Teacher> tea=adminService.selectTeacher();
		mav.addObject("teacher", tea);
		mav.setViewName("admin/adminSelect");
		return mav;
	}

	@RequestMapping(value = "/selectComments")
	public ModelAndView selectComments(){
		ModelAndView mav=new ModelAndView();
		List<Comments> com=adminService.selectComments();
		mav.addObject("comments", com);
		mav.setViewName("admin/adminSelect");
		return mav;
	}

	@RequestMapping(value = "/selectVideo")
	public ModelAndView selectVideo(){
		ModelAndView mav=new ModelAndView();
		List<Video> vid=adminService.selectVideo();
		mav.addObject("video", vid);
		mav.setViewName("admin/adminSelect");
		return mav;
	}

	@RequestMapping(value = "/selectNotes")
	public ModelAndView selectNotes(){
		ModelAndView mav=new ModelAndView();
		List<Notes> not=adminService.selectNotes();
		mav.addObject("notes", not);
		mav.setViewName("admin/adminSelect");
		return mav;
	}

	@RequestMapping(value = "/selectQuestion")
	public ModelAndView selectQuestion(){
		ModelAndView mav=new ModelAndView();
		List<Question> que=adminService.selectQuestion();
		mav.addObject("question", que);
		mav.setViewName("admin/adminSelect");
		return mav;
	}

	@RequestMapping(value = "/selectClass")
	public ModelAndView selectClass(){
		ModelAndView mav=new ModelAndView();
		List<Cclass> cla=adminService.selectClass();
		mav.addObject("cclass", cla);
		mav.setViewName("admin/adminSelect");
		return mav;
	}
	@RequestMapping(value = "/deleteStudent")
	public ModelAndView deleteStudent(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		String idString = request.getParameter("id");
		int id=Integer.parseInt(idString);
		
		adminService.deleteStudent(id);
		List<Student> stu=adminService.selectStudent();
		mav.addObject("student", stu);
		mav.setViewName("admin/adminSelect");
		return mav;
	}
	
	@RequestMapping(value = "/deleteTeacher")
	public ModelAndView deleteTeacher(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		String idString = request.getParameter("id");
		int id=Integer.parseInt(idString);
		
		adminService.deleteTeacher(id);
		List<Teacher> tea=adminService.selectTeacher();
		mav.addObject("teacher", tea);
		mav.setViewName("admin/adminSelect");
		return mav;
	}

	@RequestMapping(value = "/deleteComments")
	public ModelAndView deleteComments(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String idString = request.getParameter("id");
		int id=Integer.parseInt(idString);
		adminService.deleteComments(id);
		List<Comments> com=adminService.selectComments();
		mav.addObject("comments", com);
		if(session.getAttribute("usertype").equals("admin")){
			mav.setViewName("admin/adminSelect");
		}else{
			String vidString = request.getParameter("vid");
			int vid=Integer.parseInt(vidString);
			Tools.prompt(response, "删除成功", "../video/details?vid="+vid);
//			mav.setViewName("user/index");
		}
		return mav;
	}

	@RequestMapping(value = "/deleteVideo")
	public ModelAndView deleteVideo(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String idString = request.getParameter("id");
		int id=Integer.parseInt(idString);
		
		adminService.deleteVideo(id);
		List<Video> vid=adminService.selectVideo();
		mav.addObject("video", vid);
		if(session.getAttribute("usertype").equals("admin")){
			mav.setViewName("admin/adminSelect");
		}else{
			Tools.prompt(response, "删除成功", "../teacher/selectVideoByTeid");
		}
		return mav;
	}

	@RequestMapping(value = "/deleteNotes")
	public ModelAndView deleteNotes(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String idString = request.getParameter("id");
		int id=Integer.parseInt(idString);
		adminService.deleteNotes(id);
		List<Notes> not=adminService.selectNotes();
		mav.addObject("notes", not);
		if(session.getAttribute("usertype").equals("admin")){
			mav.setViewName("admin/adminSelect");
		}else{
			Tools.prompt(response, "删除成功", "../student/notes");
		}
		return mav;
	}

	@RequestMapping(value = "/deleteQuestion")
	public ModelAndView deleteQuestion(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String idString = request.getParameter("id");
		int id=Integer.parseInt(idString);
		adminService.deleteQuestion(id);
		List<Question> que=adminService.selectQuestion();
		mav.addObject("question", que);
		if(session.getAttribute("usertype").equals("admin")){
			mav.setViewName("admin/adminSelect");
		}else{
			Tools.prompt(response, "删除成功", "../teacher/selectQuestionByTeid");
		}
		return mav;
	}

	@RequestMapping(value = "/deleteClass")
	public ModelAndView deleteClass(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String idString = request.getParameter("id");
		int id=Integer.parseInt(idString);
		adminService.deleteClass(id);
		List<Cclass> cla=adminService.selectClass();
		mav.addObject("cclass", cla);
		if(session.getAttribute("usertype").equals("admin")){
			mav.setViewName("admin/adminSelect");
		}else{
			Tools.prompt(response, "删除成功", "../teacher/selectClassByTeid");
		}
		return mav;
	}
	
}
