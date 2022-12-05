package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import kr.bit.entity.Member;

@Mapper //생략가능
public interface BoardMapper {
	public List<Board> getList(Criteria cri); //리스트 가져오기
	public void insert(Board vo); //글쓰기
	public void insertSelectKey(Board vo); //글쓰기
	public Member login(Member vo); //로그인
	public Board read(int idx); //게시글 상세보기
	public void update(Board vo); //게시글 수정하기
	public void delete(int idx); //게시글 삭제하기
	public void replySeqUpdate(Board parent); //게시글 답글 업데이트(부모글 정보저장)
	public void replyInsert(Board vo); //게시글 답글 저장하기 
	public int totalCount(Criteria cri); //전체페이지 수 계산
}
