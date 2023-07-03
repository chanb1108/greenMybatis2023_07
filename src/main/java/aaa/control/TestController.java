package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.StudCalc;

@Controller
public class TestController {

	@RequestMapping("/basic/test")
	String test(Model mm) {
		
		mm.addAttribute("st1",new StudCalc("박찬빈",99,98,97));
		mm.addAttribute("st2",new StudCalc("장희빈",89,88,87));
		mm.addAttribute("st3",new StudCalc("자바빈",79,78,77));
		mm.addAttribute("st4",new StudCalc("파이참빈",69,68,67));
		mm.addAttribute("st5",new StudCalc("미스터빈",59,58,57));
		return "basic/test";
	}
	
}
