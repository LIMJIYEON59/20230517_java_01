package member.model.vo;

import java.lang.*;

public class Member {
	private String name;
	private int age;
	private java.util.Date enrollDate; 
	private java.sql.Date enrollDate2;
	
	public Member() {}
	public Member(String name, int age) {
		this.name =name;
		this.age = age; 
	}
	
	}
