package kr.bit.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

//@RestController -> json으로 출력
@Controller
public class HelloController {

	@RequestMapping("/")
	public String hello() {
		return "index"; //index.jsp
	}
}
