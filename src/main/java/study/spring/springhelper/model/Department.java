package study.spring.springhelper.model;

import lombok.Data;

// 테이블 구조에 맞춘 Java Beans 생성
@Data
public class Department
{
	private int deptno;
	private String dname;
	private String loc;
	
	// SQL에 적용할 Limit절에 대한 변수 추가
	// 모든 데이터가 동일한 값들을 중복해서 갖고 있을 필요는 없으므로 static처리
	
	// 페이지 구현이 필요한 경우 아래 속성들을 추가한다. (static)
	private static int offset;		// LIMIT 절에서 사용할 검색 시작 위치
	private static int listCount;	// LIMIT 절에서 사용할 검색할 데이터 수
	
	public static int getOffset()
	{
		return offset;
	}
	public static void setOffset(int offset)
	{
		Department.offset = offset;
	}
	public static int getListCount()
	{
		return listCount;
	}
	public static void setListCount(int listCount)
	{
		Department.listCount = listCount;
	}
	
	

}
