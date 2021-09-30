package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@ToString
public class BoardServiceImpl implements BoardService {

	// final이고 requiredArgsConstructor 쓰면 자동으로 주입해줌
	private final BoardMapper mapper;

	@Override
	public Long register(BoardVO board) {
		// 등록

		mapper.insertSelectKey(board);

		return board.getBno();
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub

		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board);
	}

	@Override
	public int remove(Long bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri);
	}
}
