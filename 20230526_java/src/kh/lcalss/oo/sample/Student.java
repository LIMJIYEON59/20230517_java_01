package kh.lcalss.oo.sample;

public class Student extends Person{
	private String name;
//	private int age;
//	private char gender;
	private int score;
	private int grade;
	private final int maxCount=10;
	
	
	public Student() {
		super(); //person() 
//		super("김말똥", 22, '남'); // person("김말똥", 22, '남'); 
	}
	public Student(String name, char gender, int age, int grade) {
		super(name,age,gender);	//super는 가장 먼저 적어줘야한다. (안그러면 오류난다)
		this.name = name;
		this.grade = grade;
		
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", grade=" + grade 
				+ ", toString()=" + super.toString()
				+ ", getGender()=" + getGender() + "]";
	}
	@Override
	public String getName() {
		return this.name;
	
	}
	
	@Override
	//오버라이딩
	public int getAge() {
		return super.getAge()+1;  //person에 있는 getAge값을 +1해서 return 해주겠다.
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGrade() {
		return grade;
	}

	public  void setGrade(int grade) {
		this.grade = grade;
	}
	
	}
