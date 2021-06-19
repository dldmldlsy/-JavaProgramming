package kr.ac.inha.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inha.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/welcome.do")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		return mv;
	}
	
	//회원가입페이지나오게
	@RequestMapping("/member/addMember.do")
	public ModelAndView addMember() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/addMember");
		return mv;
	}
	
	//회원가입등록
	@RequestMapping("/member/processAddMember.do")
	public ModelAndView processAddMember(String id, String pw, String nickname, String name, String mail, String hello) {
		HashMap<String, String>  hashmap=new HashMap<>(); 
		hashmap.put("id", id);
		hashmap.put("pw",pw);
		hashmap.put("nickname", nickname);
		hashmap.put("name", name);
		hashmap.put("mail", mail);
		hashmap.put("hello", hello);
		try {
		memberService.processAddMember(hashmap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return welcome();
	}
	
	//수정페이지나오게
	@RequestMapping("/member/updateMember.do")
	public ModelAndView updateMember(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/updateMember");
		HttpSession session= request.getSession(); //세션얻어오기
		String id= session.getAttribute("sessionId").toString(); 
		HashMap<String, String> member=memberService.getMember(id);
		mv.addObject("member", member);
		return mv;
	}
	
	//수정기능동작
	@RequestMapping("/member/processUpdateMember.do")
	public ModelAndView processUpdateMember(String id, String pw, String nickname, String name, String mail, String hello) {
		HashMap<String, String> hashmap=new HashMap<>(); 
		hashmap.put("id",id);
		hashmap.put("pw",pw);
		hashmap.put("nickname", nickname);
		hashmap.put("name", name);
		hashmap.put("mail", mail);
		hashmap.put("hello", hello);
		try{
		memberService.processUpdateMember(hashmap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return welcome();
	}
	
	//로그인페이지나오게
	@RequestMapping("/member/loginMember.do")
	public ModelAndView loginMember() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("/member/loginMember");
		
		return mv;
	}
	
	//로그인기능수행
	@RequestMapping("/member/processLoginMember.do")
	public ModelAndView processLoginMember(HttpServletRequest request, String id, String pw) throws Exception {
		HashMap<String, String> member =memberService.getMember(id);
		ModelAndView mv=new ModelAndView();
		if(!(member.get("PW").equals(pw))) {
			mv.addObject("msg","틀림");
			mv.setViewName("/member/loginMember");
			return mv;
		}
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", member.get("ID"));
		return welcome();
	}
	
	//로그아웃 누르면 로그아웃기능실행
	@RequestMapping("/member/logoutMember.do")
	public ModelAndView logoutMember(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return welcome();
	}
	
	//회원탈퇴버튼 누를시 회원탈퇴기능 동작
	@RequestMapping("/member/deleteMember.do")
	public ModelAndView deleteMember(HttpServletRequest request, String id) {
		try {
			HttpSession session=request.getSession();
			session.invalidate();
			memberService.deleteMember(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return welcome();		
	}
}
