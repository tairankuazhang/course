package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.Cclass;
import pojo.Student;
import pojo.Teacher;
import pojo.Video;
import service.IndexService;
import tools.Tools;


@Controller

@RequestMapping("")
public class IndexController {

	@Autowired(required=false)
	IndexService indexService;
	
	@RequestMapping("/login")
	public String adminlogin() {
		return "user/login";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ModelAndView userlogin(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		String name = new String(request.getParameter("uname").getBytes("iso-8859-1"), "utf-8");
		String password = request.getParameter("password");
		String type = request.getParameter("usertype");
		ModelAndView mav=new ModelAndView();
		if(type.equals("1")){
			Student stu=indexService.findStudent(name);
			if(password.equals(stu.getS_password())){
				session.setAttribute("usertype", "student");
				session.setAttribute("username", name);
				session.setAttribute("userid", stu.getS_id());
				session.setMaxInactiveInterval(30*60);
				Tools.prompt(response, "登录成功", "../student/home");
				return mav;
			}else{
				Tools.prompt(response,"用户名或密码错误","../login");
				return mav;
			}
		}else if(type.equals("0")){
			Teacher tea=indexService.findTeacher(name);
			if(password.equals(tea.getTe_password())){
				session.setAttribute("usertype", "teacher");
				session.setAttribute("username", name);
				session.setAttribute("userid", tea.getTe_id());
				session.setMaxInactiveInterval(30*60);
				Tools.prompt(response, "登录成功", "../student/home");
//				mav.setViewName("teacher/index");
				return mav;
			}else{
				Tools.prompt(response,"用户名或密码错误","../login");
				return mav;
			}
		}else if(type.equals("2")){
			String pass=indexService.findAdmin(name);
			if(password.equals(pass)){
				session.setAttribute("usertype", "admin");
				session.setAttribute("username", name);
				session.setMaxInactiveInterval(30*60);
				mav.setViewName("admin/index");
				return mav;
			}else{
				Tools.prompt(response,"用户名或密码错误","../login");
				return mav;
			}
		}
		mav.setViewName("user/login");
		return mav;
	}
	
	@RequestMapping(value = "/logout")
	public String outlogin(HttpServletRequest request,HttpSession session){
		session.invalidate();
		return "user/login";
	}
	
	@RequestMapping(value = "/user/registered")
	public String registered(){
		return "user/registered";
	}
	
	@RequestMapping(value = "/addUser")
	public ModelAndView addUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView mav=new ModelAndView();
		
		String[] information=Tools.MoveFiles(request, 5,"image");
		String name=information[0];
		String password=information[1];
		String gender;
		if(information[2].equals("0")){
			gender="男";
		}else{
			gender="女";
		}
		if(information[3].equals("0")){
			Student stu=new Student();
			stu.setS_name(name);
			stu.setS_password(password);
			stu.setS_gender(gender);
			stu.setS_pic(information[4]);
			int i=indexService.addStudent(stu);
			if(i==1){
				Tools.prompt(response, "插入学生"+name+"成功", "./login");
			}else{
				Tools.prompt(response, "插入学生失败，请重新操作", "./user/registered");
			}
		}else{
			Teacher tea=new Teacher();
			tea.setTe_name(name);
			tea.setTe_password(password);
			tea.setTe_gender(gender);
			tea.setTe_pic(information[4]);
			int i=indexService.addTeacher(tea);
			if(i==1){
				Tools.prompt(response, "插入教师"+name+"成功", "./login");
			}else{
				Tools.prompt(response, "插入教师失败，请重新操作", "./user/registered");
			}
		}
		mav.setViewName("user/login");
		return mav;
	}
	
	@RequestMapping(value = "/type")
	public ModelAndView type(HttpServletRequest request) throws UnsupportedEncodingException{
		ModelAndView mav = new ModelAndView();
		String strTypeid = request.getParameter("tyid");
		int typeid=Integer.parseInt(strTypeid);
		List<Video> listVideo=indexService.selectVideoByTypeId(typeid);
		mav.addObject("listVideo",listVideo);
		mav.setViewName("video/type");
		return mav;
	}

	@RequestMapping(value = "/user/userDetails")
	public ModelAndView userDetails(HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int userid=(int)session.getAttribute("userid");
		if(session.getAttribute("usertype").equals("student")){
			Student stu=indexService.selectStudentById(userid);
			mav.addObject("student", stu);
		}else{
			Teacher tea=indexService.selectTeacherById(userid);
			mav.addObject("teacher", tea);
		}
		mav.setViewName("user/details");
		return mav;
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
//		List<Student> listStudent = indexService.selectStudentByName(name);
//		if(listStudent.isEmpty()){
//			listStudent=null;
//		}
//		mav.addObject("listStudent", listStudent);
//		List<Teacher> listTeacher = indexService.selectTeacherByName(name);
//		if(listTeacher.isEmpty()){
//			listTeacher=null;
//		}
//		mav.addObject("listTeacher", listTeacher);
		List<Cclass> listClass = indexService.selectClassByName(name);
		if(listClass.isEmpty()){
			listClass=null;
		}
		mav.addObject("listClass", listClass);
		List<Video> listVideo = indexService.selectVideoByName(name);
		if(listVideo.isEmpty()){
			listVideo=null;
		}
		mav.addObject("listVideo", listVideo);
		mav.setViewName("user/search");
		return mav;
	}
}
