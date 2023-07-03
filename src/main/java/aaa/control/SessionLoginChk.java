package aaa.control;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import aaa.model.LoginMember;

@Service
public class SessionLoginChk {

	public boolean hasErrors(LoginMember lm, BindingResult bRes) {
		
		
		if(bRes.hasErrors()) {
			
			return true;
			
		}else if(!lm.getLogData().containsKey(lm.getPid())) {
			
			bRes.rejectValue("pid", null, "존재하지 않는 ID입니다.");
			return true;
			
		}else {
			if(!lm.getLogData().get(lm.getPid()).equals(lm.getPw())) {
				bRes.rejectValue("pw", null, "비밀번호가 잘못되었습니다.");
				return true;
			}
		}
		
		return false;
		
	}
	
}
