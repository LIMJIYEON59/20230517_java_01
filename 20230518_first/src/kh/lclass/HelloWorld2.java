package kh.lclass;

public class HelloWorld2 {

	public static void main(String[] args) {
		// JVM이 main 메소드를 호출해줌.
//
//		BankAccount ejkim = new BankAccount();
//		ejkim.accountNo =1111;
//		ejkim.setName("이제이");
//		ejkim.setBalance(5000);
//
//		// 시간이 흘러서.
//		int currenBalance = ejkim.deposit("역삼우리은행ATM3", 5000);
//		System.out.println(ejkim.getName() + "님의 잔액" + currenBalance + "입니다");

		final int NUMBER_OF_STUDENT = 10;
//			final int NUMBER_OF_STUDENT = 10;
//			final int NUMBER_OF_STUDENT = 10;

		boolean a1;
		byte a2; // -128~127(0포함)
		short a3;
		int a4; // 정수 기본 연산 자료형
		long a5;
		float a6;
		double a7; // 실수 기본 연산 자료형
		char a8;
		System.out.println("aaa");
		a1 = true;
		System.out.println(a1);
		a2 = 3 + 5 * 2;
		System.out.println((int)a2);
		a3 = 20;
		System.out.println(a3);
		a4 = 20;
		System.out.println(a4);
		a5 = 10000000000l;
		System.out.println(a5);
		a6 = 20f;
		System.out.println(a6);
		a7 = 20;
		System.out.println(a7);
		a8 = 'A';
		System.out.println(a8);
		a8 = 65;
		System.out.println(a8);
		a2 = 20 * 6;

		System.out.println("aaa"); // out 필드명이다.
		/*
		 * public class System { public Abcdef out; //참조형
		 * 
		 * 
		 * public class Abcdef { public void println(String a1) { //console창에 a1 뿌리기
		 * return;
		 */

	}

}
