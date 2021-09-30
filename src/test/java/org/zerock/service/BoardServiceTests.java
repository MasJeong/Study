package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

//스프링 로딩 할 떄 필요 소스(복붙해서 사용하자)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testPrint() {
		
		log.info(service);
	}
	
	@Test
	public void testGetList() {
		
		//getList() 객체의 결과 값을 가지고 forEach 함수의 내장 for문 메서드 실행.
		//getList() 함수의 결과 값을 하나씩 BoardVO 타입의 board로 넘긴다.
		//getList() 결과 값이 없을 때까지 log.info(board)를 실행한다.
		
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testResister() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("AAATest 테스트");
		vo.setContent("AAAContent 테스트");
		vo.setWriter("AAAtester");
		
		long bno = service.register(vo);
		
		log.info("BNO: " + bno);
	}
}







