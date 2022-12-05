package kr.bit.service;

import java.util.List;

import kr.bit.entity.Board;

public interface BoardService {
	
	public List<Board> getList(); //전체리스트 가져오기
	public void register(Board vo); //글 등록하기
	
}
