package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

//Test for Controller
@WebAppConfiguration

@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

@Log4j
public class BoardControllerTests {
	
	@Setter(onMethod_ = {@Autowired} )
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	//Before가 적용된 메서드는 모든 테스트 전에 매번 실행되는 메서드
	@Before
	public void setup() {
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		
		log.info(
			mockMvc.perform(
				MockMvcRequestBuilders.get("/board/list"))
			.andReturn()
			.getModelAndView()
			.getModelMap());
			
	}
	
	@Test
	public void testRegister() throws Exception{
		
		log.info(
			mockMvc.perform(
				MockMvcRequestBuilders.post("/board/register")
				.param("title", "Test 테스트")
				.param("content", "Content")
				.param("writer", "user10")
				)
			.andReturn()
			.getModelAndView()
			.getModelMap());
			
	}
	
	@Test
	public void testModify() throws Exception{
		
		log.info(
			mockMvc.perform(
				MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "3")
				.param("title", "수정된 테스트 새글 제목")
				.param("content", "수정된 테스트 새글 내용")
				.param("writer", "user20")
				)
			.andReturn()
			.getModelAndView()
			.getModelMap());
			
	}
	
	//MockMvc를 이용해서 파라미터 전달할 때는 문자열로만 처리해야 함.
	@Test
	public void testRemove() throws Exception{
		
		log.info(
			mockMvc.perform(
				MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "22")
				)
			.andReturn()
			.getModelAndView()
			.getModelMap());
			
	}
}






