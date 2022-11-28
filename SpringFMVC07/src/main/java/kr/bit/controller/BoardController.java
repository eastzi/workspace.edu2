package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.bit.entity.Board;
import kr.bit.service.BoardService;

@Controller //-> POJO
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String getList(Model model) {
		// POJO 역할 3가지 
		
		//1. db에서 리스트 가져오기 - Model 연동
		List<Board> list = boardService.getList();
		//2. 객체바인딩
		model.addAttribute("list", list); 
		//3. nextPage 리턴
		return "board/list";
	}
	
	@GetMapping("/register")
	public String register() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(Board vo, RedirectAttributes rttr) { //vo에 파라메터 수집 --> web.xml에 한글인코딩
		//System.out.println(vo);
		boardService.register(vo); //게시물 등록
		System.out.println(vo);
		rttr.addFlashAttribute("result", vo.getIdx()); //${result} 로 출력
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public String get(@RequestParam("idx") int idx, Model model) {
		Board vo = boardService.get(idx);
		model.addAttribute("vo", vo);
		return "board/get"; //get.jsp
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam("idx") int idx, Model model) {
		Board vo = boardService.get(idx);
		model.addAttribute("vo", vo);
		return "board/modify"; //modify.jsp
	}
	
	@PostMapping("/modify")
	public String modify(Board vo) {
		boardService.modify(vo); //수정
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public String remove(int idx) {
		boardService.remove(idx);
		return "redirect:/board/list";
	}
	
	@GetMapping("/reply")
	public String reply(int idx, Model model) {
		Board vo = boardService.get(idx);
		model.addAttribute("vo", vo);
		return "board/reply"; //reply.jsp
	}
	
	@PostMapping("/reply")
	public String reply(Board vo) {
		// 답글에 필요한 처리 -> service단에서 처리
		boardService.replyProcess(vo); //답글 저장
		return "redirect:/board/list";
	}
}
