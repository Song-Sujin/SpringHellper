package study.spring.springhelper.helper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PageData
{
	// GET파라미터로 처리할 값
	private int nowPage = 1;	// 현재 페이지 번호
	
	// DB에서 조회한 결과 값
	private int totalCount = 0;	// 전체 글 개수 조회
	
	// 개발자가 정의해야 하는 값
	private int listCount = 10;	// 한 페이지에 보여질 글의 목록 수
	private int groupCount = 5;	// 한 그룹에 표시할 페이지번호 개수
	
	// 연산처리가 필요한 값
	private int totalPage = 0;	// 전체 페이지 수
	private int startPage = 0; 	// 현재 그룹의 시작 페이지
	private int endPage = 0; 	// 현재 그룹의 마지막 페이지
	private int prevPage = 0;	// 이전 그룹의 마지막 페이지
	private int nextPage = 0;	// 이전 그룹의 첫 페이지
	private int offset = 0;		// MySQL의 Limit 시작 위치
	
	// 객체가 만들어짐과 동시에 필요한 연산을 일괄 수행하는 생성자
	public PageData(int nowPage, int totalCount, int listCount, int groupCount)
	{
		// 멤버변수에 파라미터 복사
		this.nowPage = nowPage;			// 23페이지
		this.totalCount = totalCount;	// 337개의 게시글
		this.listCount = listCount;		// 10개씩 노출
		this.groupCount = groupCount;	// 5개의 페이지번호 노출로 지정
		
		// 전체 페이지 수
		totalPage = ((totalCount - 1) / listCount) + 1;		// (337-1) / 10 + 1 = 34 -> 총 34페이지
		
		// 현재 페이지에 대한 오차 조절
		if(nowPage < 0)		// 현재페이지가 0보다 작으면?
			nowPage = 1;	// 현재페이지는 1페이지
		
		if(nowPage > totalPage)		// 현재페이지가 34페이지보다 크면?
			nowPage = totalPage;	// 현재페이지는 마지막페이지
		
		// 현재 페이징 그룹의 시작 페이지 번호
		startPage = ((nowPage - 1) / groupCount) * groupCount + 1;	// ((23-1) / 5) * 5 + 1 = 21 -> 21페이지가 현재 그룹의 시작 
		
		// 현재 페이징 그룹의 끝 페이지 번호
		endPage = (((startPage - 1) + groupCount) / groupCount) * groupCount;	// (((21-1) + 5) / 5) * 5 = 25 -> 25페이지가 마지막
		
		// 끝 페이지 번호가 전체 페이지수를 초과하면 오차범위 조절
		if(endPage > totalPage)		// 25페이지가 34페이지보다 크면?
			endPage = totalPage;	// 크지않으니 마지막 페이지는 34페이지가 맞음
									// 35페이지가 34페이지보다 크면?
									// 그럴일은 없겠지만 그럴땐 35페이지가 마지막으로 변경
		
		// 이전 그룹의 마지막 페이지
		if(startPage > groupCount)		// 21페이지가 5보다 크면?
			prevPage = startPage - 1;	// 이전 그룹의 마지막 페이지는 21-1인 20페이지
		else
			prevPage = 0;				// 아닐경우에는 아직 첫번째 페이지이므로 0
		
		// 다음 그룹의 첫 페이지
		if(endPage < totalPage)			// 25페이지가 34페이지보다 작으면?
			nextPage = endPage + 1;		// 다음 그룹의 첫 페이지는 25+1인 26페이지
		else
			nextPage = 0;				// 아닐경우에는 마지막 페이지이므로 0
		
		// 검색 범위의 시작 위치
		offset = (nowPage - 1) * listCount;	// (23-1) * 10 = 220 -> 337개의 게시글 중 220번째 부터 시작 
		
		// 계산 결과를 로그로 기록한다.
		log.debug(this.toString());
		
	}

}
