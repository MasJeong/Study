package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	//이번에는 @select 어노테이션 안 쓰고 BoardMapper.xml에서 처리하기
	List<BoardVO> getList();
	
	//일단 애매하니까 return타입 void로
	void insert(BoardVO board);
	
	void insertSelectKey(BoardVO board);
	
	BoardVO read(Long bno);
	
	//수정 삭제 시, int형을 주로 사용,
	int delete(Long bno);
	
	int update(BoardVO board);
	
	//페이징처리
	List<BoardVO> getListWithPaging(Criteria cri);
	
	//Criteria 파라미터 받는 건 검색 조건을 Criteria 안에 추가할 거.
	int getTotalCount(Criteria cri);
}
