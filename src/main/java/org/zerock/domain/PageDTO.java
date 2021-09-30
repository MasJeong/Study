package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
//현재 페이지 번호, 토탈 카운트 값 필요
	
	private int startPage, endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
							//0.3 -> 1 -> 10page
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		
		this.startPage = endPage - 9;
		
		this.prev = this.startPage > 1;
							//71.0 / 10 -> 7.1 -> 8page
							//300.0 / 10 -> 30 -> 30page
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()) );
		
		this.endPage = realEnd <= endPage? realEnd : endPage;
		
		this.next = this.endPage < realEnd;
	}
	
	
}
