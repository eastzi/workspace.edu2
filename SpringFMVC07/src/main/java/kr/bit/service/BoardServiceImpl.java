package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.entity.Board;
import kr.bit.entity.Member;
import kr.bit.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<Board> getList() {
		// 고객의 요구사항을 반영하는 로직 - service 
		List<Board> list = boardMapper.getList();
		
		return list;
	}

	@Override
	public Member login(Member vo) {
		Member mvo = boardMapper.login(vo); 
		return mvo;
	}

	@Override
	public void register(Board vo) {
		boardMapper.insertSelectKey(vo);
	}

	@Override
	public Board get(int idx) {
		Board vo = boardMapper.read(idx);
		return vo;
	}

	@Override
	public void modify(Board vo) {
		boardMapper.update(vo);
	}

	@Override
	public void remove(int idx) {
		boardMapper.delete(idx);
	}

	@Override
	public void replyProcess(Board vo) {
		// 답글만들기
		// 1. 부모글(원글)의 정보 가져오기 -> 부모글 idx 가져오기
		Board parent = boardMapper.read(vo.getIdx());
		
		// 2. 부모글의 boardGroup의 값을 답글 정보에 저장하기 - 부모글과 답글의 묶음
		vo.setBoardGroup(parent.getBoardGroup());
		
		// 3. 부모글의 boardSequence 값에 1을 더해서 답글 정보 저장하기 - 답글의 순서
		vo.setBoardSequence(parent.getBoardSequence() + 1);
		
		// 4. 부모글의 boardLevel 값에 1을 더해서 답글 정보 저장하기 - 답글의 들여쓰기
		vo.setBoardLevel(parent.getBoardLevel() + 1);
		
		// 5. 같은 boardGroup에 있는 글 중 
		//    부모글의 boardSequence보다 큰 값들을 모두 1씩 업데이트
		boardMapper.replySeqUpdate(parent);
		
		// 6. 답글 저장하기
		boardMapper.replyInsert(vo);
		
	}

}
