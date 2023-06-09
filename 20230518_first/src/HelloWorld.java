import kh.lclass.bank.BankAccount;

public class HelloWorld {

	public static void main(String[] args) {
		//JVM 이  main 메소드를 호출해줌
		
//		BankAccount ejkim = new BankAccount();  //ejkim의 자료형은 참초 자료형 BankAccount
//		ejkim.setName("이제이");
//		ejkim.setBalance(5000);
		
		//시간이 흘러서..
//		int currentBalance = ejkim.deposit("역삼우리은행ATM3", 5000);
//		System.out.println("잔액" + currentBalance +"입니다.");
		
		boolean a1;
		byte a2; //-128~127
		short a3; //
		int a4; // 정수 '기본 연산 자료형'
		long a5; //
		float a6; //
		double a7; // 실수 '기본 연산 자료형'
		
		char a8;
		
		a1 = true;	System.out.println(a1);
		a2 = 3+5*2;	System.out.println(a2);
		a3 = 20;	System.out.println(a3);
		a4 = 20;	System.out.println(a4);
		a5 = 1000000000L;	System.out.println(a5);
		a6 = 20.0f;	System.out.println(a6);
		a7 = 20.1212123123212111111111;		System.out.println(a7);
		a8 = 'A'; /*65*/	System.out.println(a8);
		a8 = 65;/*'A'*/		System.out.println(a8);
		a5 = 20L;		System.out.println(a5);
		a5 = 20l;		System.out.println(a5);
		
		System.out.println("aaa");
		//클래스명.필드명.메소드
		
		/*System.out.println("Hello~ World!!!");
		System.out.print("AD");
		System.out.print("Hello~ \nWorld22222");
		System.out.print("Hello~ World33");
		System.out.print("bbb");*/
		
	}
}
	
	/* 05.22
	public class System{
		public 참조형 out;
		public Abcdef out;
		}
		
	public class Abcdef{
		public void println(String a1){
			//콘솔창에 a1 뿌리기
			return;
		}
	}
	 
	 */
	 

