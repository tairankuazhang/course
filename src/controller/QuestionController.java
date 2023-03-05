package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Question;
import service.QuestionService;
import tools.Tools;


@Controller

@RequestMapping("/question")
public class QuestionController {
	@Autowired(required=false)
	QuestionService questionService;
	
	@RequestMapping(value = "/insert")
	public ModelAndView insertQuestion(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String topic = new String(request.getParameter("topic").getBytes("iso-8859-1"), "utf-8");
		String answer = new String(request.getParameter("answer").getBytes("iso-8859-1"), "utf-8");
		String strvid=request.getParameter("vid");
		int vid=Integer.parseInt(strvid);
		int tid=(int)session.getAttribute("userid");
		Question question=new Question();
		question.setQ_topic(topic);
		question.setQ_answer(answer);
		question.setQ_vid(vid);
		question.setQ_tid(tid);
		int i=questionService.insertQuestion(question);
		if(i==1){
			Tools.prompt(response, "添加成功", "../teacher/selectQuestionByTeid");
		}else{
			Tools.prompt(response, "添加失败，请重新操作", "../teacher/selectQuestionByTeid");
		}
		return mav;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView updateQuestion(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		ModelAndView mav=new ModelAndView();
		String topic = new String(request.getParameter("topic").getBytes("iso-8859-1"), "utf-8");
		String answer = new String(request.getParameter("answer").getBytes("iso-8859-1"), "utf-8");
		String strvid=request.getParameter("vid");
		int vid=Integer.parseInt(strvid);
		String strqid=request.getParameter("qid");
		int qid=Integer.parseInt(strqid);
		Question question=new Question();
		question.setQ_topic(topic);
		question.setQ_answer(answer);
		question.setQ_vid(vid);
		question.setQ_id(qid);
		int i=questionService.updateQuestion(question);
		if(i==1){
			Tools.prompt(response, "修改成功", "../teacher/selectQuestionByTeid");
		}else{
			Tools.prompt(response, "修改失败，请重新操作", "../teacher/selectQuestionByTeid");
		}
		return mav;
	}
}
