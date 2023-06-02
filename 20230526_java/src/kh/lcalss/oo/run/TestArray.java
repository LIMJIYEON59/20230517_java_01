package kh.lcalss.oo.run;

import kh.lcalss.oo.sample.Person;
import kh.lcalss.oo.sample.Student;

public class TestArray {
	final int a= 10;
	public static void main(String[] args) {
		
		Object obj1 = new Student();
		Object obj2 = new Person();
		Person p1 = new Student();
		Student s1 = new Student();
		
		
		
		final int b =11;
		int n=0;
		for(final double maxCnt=5;n<10;n++) {
			System.out.println("테스트" +n);
		}
		// 방법 1
		Person[] personArray2 = new Person[] {new Person(), new Person(), new Person()};
		// 방법 2
		Person[] personArray = new Person[22];
		for(int i=0; i<personArray.length; i++) {
			personArray[i] = new Person();
			
		}
		// 아래와 같이 하면 오류발생 (NullPointerException)
		Person[] personArray3 = new Person[22];
		personArray[0].setAge(25);
		//NullPointerException
		//원인: . 점 앞에 있는 변수(객체 = 인스턴스)가 null 상태
		//즉 personArrat[0]이 null 주소값을 가지고 있었음.
		//해결방법 : 변수(객체=인스턴스)에 new 생성자(); 를 해줌
		personArray3[0] = new Person();
		personArray3[0].setAge(25);
		personArray3[0].setName("김소소");
		personArray3[0].setGender('여');
		
		personArray[1] = new Person("김개똥", 19, '남');
		personArray[1] = new Person("김말똥", 22, '남'); 
		
		//오버라이딩(추가적으로 코드 적음)
		System.out.println(personArray3[0].getName());
		
		System.out.println("=== studentArr ===");
		
		Student[] stdArray = new Student[3]; 		 //new 배열생성
		for(int i=0; i<stdArray.length; i++) {
			stdArray[i] = new Student()  {	
				@Override
				public int getGrade() {
					return 0;
					
				}
				@Override
				public void setGrade(int grade) {	//new 객체생성
					System.out.println("학년" + 3);
					//override 안에 있는 i는 for 안의 i와는 다르게 적용됨
				}
			};
						
		}
		stdArray[0].setAge(15);
		stdArray[0].setName("김영희");
		stdArray[0].setGender('여');
		
		stdArray[0].setScore(85);
		stdArray[0].setGrade(3);
		
		System.out.println(stdArray[0].getAge());	
		System.out.println(stdArray[0].getName());
		System.out.println(stdArray[0].getGender());
		System.out.println(stdArray[0].toString());
		
		// Student [name=null, score=0, geade=0,  //jvm에 의해 초기화
		// toString() = person [name=김영희, age=15, gender=여]]

		Student yh = new Student("김영희", '여', 20,1) {
			@Override
			public void setGrade(int grade) {
				System.out.println("학년 지정함");
			}	
		};
	
	}
}












