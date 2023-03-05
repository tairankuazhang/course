package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.Cclass;
import pojo.Notes;
import pojo.Student;
import pojo.Teacher;
import pojo.VideoType;
import pojo.Video;
import service.StudentService;
import tools.Tools;

@Controller

@RequestMapping("/student")
public class StudentController {

	@Autowired(required=false)
	StudentService studentService;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		List<VideoType> listType=studentService.selectType();
		mav.addObject("listType",listType);
		List<Video> listVideoSort=studentService.selectVideoSort();
		mav.addObject("listVideoSort",listVideoSort);
		List<Video> listVideo=studentService.selectTypeVideo();
		mav.addObject("listVideo",listVideo);
		mav.setViewName("user/index");
		return mav;
	}
	
	@RequestMapping("/class")
	public ModelAndView cclass(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int userid=(int) session.getAttribute("userid");
		List<Cclass> listClass=studentService.selectClassById(userid);
		mav.addObject("listClass", listClass);
		mav.setViewName("student/class");
		return mav;
	}
	
	@RequestMapping("/notes")
	public ModelAndView notes(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int userid=(int) session.getAttribute("userid");
		List<Notes> notes=studentService.selectNotesById(userid);
		mav.addObject("notes", notes);
		mav.setViewName("notes/index");
		return mav;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public ModelAndView updateStudent(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		ModelAndView mav = new ModelAndView();
		String sidString = request.getParameter("sid");
		int sid=Integer.parseInt(sidString);
		String[] information=Tools.MoveFiles(request, 4, "image");
		Student student=new Student();
		student.setS_id(sid);
		student.setS_name(information[0]);
		student.setS_password(information[1]);
		student.setS_gender(information[2]);
		student.setS_pic(information[3]);
		int i=studentService.updateStudent(student);
		if(i==1){
			Tools.prompt(response, "修改成功", "../user/userDetails");
		}
		else{
			Tools.prompt(response, "修改失败,请重新操作", "../user/userDetails");
		}
		return mav;
	}
}
