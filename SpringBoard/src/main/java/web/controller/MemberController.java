package web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Member;
import web.service.face.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired private MemberService memberService; 
	
	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login() {}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginProc(Member member, HttpSession session) {
		logger.info("/login {}", member);
		
		boolean loginResult = memberService.login(member);
		
		if(loginResult) {
			logger.info("로그인 성공");

			session.setAttribute("login", true);
			session.setAttribute("id", member.getId());
			session.setAttribute("nick", memberService.getNick(member));
			
			return "redirect:/";
			
		} else {
			logger.info("로그인 실패");
			
			return "redirect:/member/login";
		}		
	}
	
	// 로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	// 회원가입
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public void join() { }
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinProc(Member member) {
		logger.info("/member/join [POST] {}", member);
		
		boolean joinResult = memberService.join(member);
		
		if(joinResult) {
			logger.info("회원가입 성공");
			return "redirect:/";
		} else {
			logger.info("회원가입 실패");
			return "redirect:/member/join";
		}
	}
	
	// 메인
	@RequestMapping(value="/main")
	public void main() { }
	
}











