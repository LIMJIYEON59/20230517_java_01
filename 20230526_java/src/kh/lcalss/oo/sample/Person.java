package kh.lcalss.oo.sample;

import java.io.Serializable;

/**
 * @author user1
 *
 */
public class Person  implements Serializable {	
	
	private static final long serialVersionUID = -6655554492649987708L;

	
	protected String name;	//주민등록증상이름
	private int age;	//만
	private transient char gender;	//'남' /'여'


	// 기본 생성자
	/**/
	/****/
	public Person () {}		//public class *** 생성자 이름, 초기값 설정
		
	
	//allArgumentsConstructor 만들어주세요.
	//allArgumentsConstructor 란 모든 매개인자를 받아서 처리하는 생성자
	//overloading 으로 생성자
	
	// getter / setter 
	
	public Person(String name, int age, char gender) {
		this.name = name; //특별한 말이 없으면 무조건 this가 달림
		this.age = age;
		this.gender = gender;
		
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void  setGender(char gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
	
	

}
