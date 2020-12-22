package study.spring.springhelper.model;

import lombok.Data;

@Data
public class Professor
{
	// 1) 기본 컬럼
	private int profno;
	private String name;
	private String userid;
	private String position;
	private int sal;
	private String hiredate;
	private Integer comm;
	private int deptno;
	
	// 2) JOIN 절에 따른 추가 컬럼
	private String dname;
	private String loc;
	
	// 3) 페이지 구현을 위한 static 변수
	private static int offset;
	private static int listCount;
	
	public static int getOffset()
	{
		return offset;
	}
	public static void setOffset(int offset)
	{
		Professor.offset = offset;
	}
	public static int getListCount()
	{
		return listCount;
	}
	public static void setListCount(int listCount)
	{
		Professor.listCount = listCount;
	}
	
	
}
