package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

//@Controller 어노테이션을 추가하여 스프링 빈으로 인식할 수 있게
@Controller
@RequiredArgsConstructor
//@RequestMapping을 통해 /board로 시작하는 모든 처리를 BoardController가 처리하도록 지정함.
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	//final 옆에 계층만 봐야해서 service...
	//mapper 보면 안되고 service를 봐야 함.
	private final BoardService service;
	
	//return 타입이 void이고 url이 있으면, 동일한 jsp 페이지를 찾는다.
//	@GetMapping("/list")
//	public void list(Model model) {
//		
//		log.info("list..........................");
//		
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("---------------------------------");
		log.info(cri);
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
	}
	
	@GetMapping("/register")
	public void registerGET() {
		
		
	}
	
	//redirect 사용할 때 해당 메소드 String으로. (등록처리)
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("board: " + board);
		
		Long bno = service.register(board);
		log.info("BNO: " + bno);
		
		//1번은 전송가능, 브라우저 주소창에 남지 않음
		rttr.addFlashAttribute("result", bno);
		
		//full path로 작성하기.
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno")Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		int count = service.modify(board);
		
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		int count = service.remove(bno);
		
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}



