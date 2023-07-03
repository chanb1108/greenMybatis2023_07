package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.LoginMember;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class SessionLoginController {

	@GetMapping("/session/login")
	String loginForm(LoginMember lm, HttpSession session) {
		System.out.println(lm.getLogData());
		
		System.out.println("session.getId():"+session.getAttribute("pid"));
		if(session.getAttribute("pid")==null) {
			return "session/loginForm";
		}else {
			return "session/loginComplete";
		}
		
	}
	
	@Resource
	SessionLoginChk sessionLoginChk;
	
	@PostMapping("/session/login")
	String loginComplete(@Valid LoginMember lm, BindingResult bRes, HttpSession session) {

		System.out.println("session/loginComplete 실행");
		System.out.println("loginComplete: "+lm.getLogData());
		if(sessionLoginChk.hasErrors(lm, bRes)) {
			return "session/loginForm";
		}else {
			session.setAttribute("pid", lm.getPid());
			session.setAttribute("pw", lm.getPw());
		}
		return "session/loginComplete";
	}
	
	@RequestMapping("/session/loginDelete")
	String loginDelete(HttpSession session) {
		
		session.invalidate();
		
		return "session/loginDelete";
	}
	
}
