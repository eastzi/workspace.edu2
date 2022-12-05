package kr.bit.entity;

import lombok.Data;

@Data
public class Criteria {
	private int page; //현재 페이지 번호
	private int perPageNum; //한 페이지 당 보여줄 게시글 갯수
	
	//검색기능에 필요한 변수
	private String type;
	private String keyword;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 5; 
	}
	//현재 페이지 게시글 시작번호 - 1페이지(1~10번), 2페이지(11~20번), 3페이지(21~30)...
	public int getPageStart() {            // 1page(0~9)  2page(10~19) 3page(20~29)
		return (page - 1) * perPageNum;    // (1-1)*10   (2-1)*10     (3-1)*10      ---> sql limit 0,10
	}
	
}
