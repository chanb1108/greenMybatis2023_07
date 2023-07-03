package aaa.model;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginMember {

	@NotEmpty(message = "ID를 입력해 주세요.")
	String pid;
	
	@NotEmpty(message = "PW를 입력해 주세요.")
	String pw;
	
	Map<String, String> logData = new HashMap<>();

	public LoginMember() {
		logData.put("aaa", "1111");
		logData.put("bbb", "2222");
		logData.put("ccc", "3333");
		logData.put("ddd", "4444");
		logData.put("eee", "5555");
	}
	
}
