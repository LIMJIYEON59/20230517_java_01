package 
	member.model.vo;

import java.util.Date;

public class Member2 {
	private String name;
	private int age;
	private Date enrollDate;
	
	public Member2() {}
	public Member2(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	
}
