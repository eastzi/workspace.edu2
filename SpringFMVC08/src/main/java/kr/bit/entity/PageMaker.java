package kr.bit.entity;

import lombok.Data;

//페이지처리 클래스
@Data
public class PageMaker {
	private Criteria cri;
	private int totalCount; //총 게시글 갯수
	private int startPage; //시작 페이지 번호
	private int endPage; //끝 페이지 번호(제일 끝 페이지번호는 조정필요)
	private boolean prev; //이전 페이지
	private boolean next; //다음 페이지
	private int displayPageNum = 5; //보여줄 페이지 갯수	
	
	// 페이징 처리를 위해 totalCount가 먼저 계산되어야 함. 
	// 1. 총 게시글 갯수를 구하는 메서드
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		makePaging();
	}

	private void makePaging() {
		// 1. 화면에 보여질 마지막 페이지 번호 
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		// 2. 화면에 보여질 시작 페이지 번호
		startPage = (endPage-displayPageNum) + 1;
		if(startPage <= 0) {
			startPage = 1;
		}
		
		// 3. 전체 마지막 페이지 계산
		int tempEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		// 4. 화면에 보여질 마지막 페이지 유효성 검사
		if(tempEndPage < endPage) {
			endPage = tempEndPage;
		}
		
		// 5. 이전 페이지 버튼(링크) 존재 여부
		prev = (startPage == 1) ? false : true;
		
		// 6. 다음 페이지 버튼(링크) 존재 여부
		next = (endPage < tempEndPage) ? true : false;  
			
	}
}
