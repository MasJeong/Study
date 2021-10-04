package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

//인터페이스 사용 목적은 실제 객체를 몰라도 되게끔 하는 것.
public interface BoardService {
	
	//키를 받아서 반환하고 싶으면 Long타입으로 변경(원래는 void)
	Long register(BoardVO board);
	
	//read는 get으로 작성하자.
	BoardVO get(Long bno);
	
	int modify(BoardVO board);
	
	int remove(Long bno);
	
	List<BoardVO> getList();
	
	List<BoardVO> getList(Criteria cri);
	
	int getTotal(Criteria cri);
}
