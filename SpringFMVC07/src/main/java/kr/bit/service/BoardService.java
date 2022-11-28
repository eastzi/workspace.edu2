package kr.bit.service;

import java.util.List;

import kr.bit.entity.Board;
import kr.bit.entity.Member;

public interface BoardService {
	
	public List<Board> getList();
	public Member login(Member vo);
	public void register(Board vo);
	public Board get(int idx); //게시글 상세보기
	public void modify(Board vo); //게시글 수정하기
	public void remove(int idx); //게시글 삭제하기
	public void replyProcess(Board vo); //게시글 답변하기
}
