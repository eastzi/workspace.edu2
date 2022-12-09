package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*") //member이하의 요청은 해당 controller에서 모두 처리함.
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "member/login"; //login.jsp
	}
}
