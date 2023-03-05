package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Cclass;
import pojo.Student;
import service.ClassService;
import tools.Tools;

@Controller

@RequestMapping("/class")
public class ClassController {
	@Autowired(required=false)
	ClassService classService;
	
	@RequestMapping(value = "/insert")
	public ModelAndView insertClass(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String strvid=request.getParameter("classId");
		int vid=Integer.parseInt(strvid);
		int tid=(int)session.getAttribute("userid");
		Cclass cclass=new Cclass();
		cclass.setCl_name(name);
		cclass.setCl_tid(tid);
		cclass.setCl_vid(vid);
		int i=classService.insertClass(cclass);
		if(i==1){
			Tools.prompt(response, "添加成功", "../teacher/selectClassByTeid");
		}else{
			Tools.prompt(response, "添加失败，请重新操作", "../teacher/selectClassByTeid");
		}
		return mav;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView updateClass(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String strvid=request.getParameter("classId");
		String strid=request.getParameter("clid");
		int vid=Integer.parseInt(strvid);
		int id=Integer.parseInt(strid);
		Cclass cclass=new Cclass();
		cclass.setCl_name(name);
		cclass.setCl_vid(vid);
		cclass.setCl_id(id);
		int i=classService.updateClass(cclass);
		if(i==1){
			Tools.prompt(response, "修改成功", "../teacher/selectClassByTeid");
		}else{
			Tools.prompt(response, "修改失败，请重新操作", "../teacher/selectClassByTeid");
		}
		return mav;
	}
	
	@RequestMapping(value = "/searchResult")
	public ModelAndView searchResult(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws UnsupportedEncodingException{
		ModelAndView mav=new ModelAndView();
		String strSearch = new String(request.getParameter("search").getBytes("iso-8859-1"), "utf-8");
		int search = Integer.parseInt(strSearch);
		System.out.println(search);
		Cclass cclass=classService.searchResult(search);
		mav.addObject("cclass",cclass);
		mav.setViewName("student/class");
		return mav;
	}
	
	@RequestMapping(value = "/insertClassStudent")
	public ModelAndView insertClassStudent(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		int cid=Integer.parseInt(request.getParameter("id"));
		int sid=(int)session.getAttribute("userid");
		int i=classService.insertClassStudent(cid,sid);
		if(i==1){
			Tools.prompt(response, "加入班级成功！", "../student/class");
		}else{
			Tools.prompt(response, "加入班级失败！", "../student/class");
		}
		return mav;
	}
	
	@RequestMapping(value = "/deleteClassStudent")
	public ModelAndView deleteClassStudent(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		int csid=Integer.parseInt(request.getParameter("id"));
		int i=classService.deleteClassStudent(csid);
		if(i==1){
			Tools.prompt(response, "已退出班级！", "../student/class");
		}else{
			Tools.prompt(response, "退出班级失败！", "../student/class");
		}
		return mav;
	}
}
