package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.Notes;
import service.NotesService;
import tools.Tools;


@Controller

@RequestMapping("/notes")
public class NotesController {

	@Autowired(required=false)
	NotesService notesService;
	
	@RequestMapping(value ="/insertNotes",method = RequestMethod.POST)
	public ModelAndView insertNotes(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		ModelAndView mav=new ModelAndView();
		String context = new String(request.getParameter("context").getBytes("iso-8859-1"), "utf-8");
		int userid=(int)session.getAttribute("userid");
		Notes notes=new Notes();
		notes.setN_content(context);
		notes.setN_sid(userid);
		int i=notesService.insertNotes(notes);
		if(i==1){
			Tools.prompt(response, "添加成功", "../student/home");
		}else{
			Tools.prompt(response, "请重新操作", "../student/home");
		}
		return mav;
	}
	
	@RequestMapping(value ="/update",method = RequestMethod.POST)
	public ModelAndView updateNotes(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		ModelAndView mav=new ModelAndView();
		String context = new String(request.getParameter("context").getBytes("iso-8859-1"), "utf-8");
		int nid=Integer.parseInt(request.getParameter("nid"));
		System.out.println("context:"+context+"nid:"+nid);
		Notes notes=new Notes();
		notes.setN_content(context);
		notes.setN_id(nid);
		int i=notesService.updateNotes(notes);
		if(i==1){
			Tools.prompt(response, "修改成功", "../student/notes");
		}else{
			Tools.prompt(response, "请重新操作", "../student/notes");
		}
		return mav;
	}
}
