package com.kh.practice3.func;

import java.util.Scanner;

public class Operator {
	public void method1() {
//		키보드로 입력 받은 하나의 정수가 양수이면 “양수다“, 양수가 아니면 “양수가 아니다“를 출력하세요.
//		ex.
//		정수 : -9
//		양수가 아니다

		Scanner sc1 = new Scanner(System.in);
		System.out.print("정수 : "); // sysout
		int num1 = sc1.nextInt();

		if (num1 >= 1) {
			System.out.println("양수다");
		} else {

			System.out.println("양수가 아니다");

		}
	}

//			키보드로 입력 받은 하나의 정수가 양수이면 “양수다“,
//			양수가 아닌 경우 중에서 0이면 “0이다“, 0이 아니면 “음수다”를 출력하세요.
//
//			ex.
//			정수 : -9
//			음수다
	public void method2() {
		Scanner sc2 = new Scanner(System.in);
		System.out.print("정수 : ");
		int num2 = sc2.nextInt();

		if (num2 >= 1) {
			System.out.println("양수다");
		} else if (num2 == 0) { // == 두 개의 항이 같으면 참
			System.out.println("0이다");

		} else {
			System.out.println("음수다");
		}

	}
//		키보드로 입력 받은 하나의 정수가 짝수이면 “짝수다“, 짝수가 아니면 “홀수다“를 출력하세요.
//
//		ex.
//		정수 : 5
//		홀수다

	public void method3() {
		Scanner sc3 = new Scanner(System.in);
		System.out.print("정수 : ");
		int num3 = sc3.nextInt();

		if (num3 % 2 == 0) {
			System.out.println("짝수다");
		} else {
			System.out.println("홀수다");
		}

	}
//		모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고
//		1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요.
//
//		ex.
//		인원 수 : 29
//		사탕 개수 : 100
//		1인당 사탕 개수 : 3
//		남는 사탕 개수 : 13

	public void method4() {
		Scanner sc4 = new Scanner(System.in);
		System.out.print("인원 수 : ");
		int num4 = sc4.nextInt();
		System.out.print("사탕 개수 : ");
		int num5 = sc4.nextInt();
		System.out.print("1인당 사탕 개수 : ");
		int num6 = sc4.nextInt();
		System.out.print("남은 사탕 개수 : ");
		int num7 = sc4.nextInt();
	}
//		키보드로 입력 받은 값들을 변수에 기록하고 저장된 변수 값을 화면에 출력하여 확인하세요.
//		이 때 성별이 ‘M’이면 남학생, ‘M’이 아니면 여학생으로 출력 처리 하세요.
//
//		ex.
//		이름 : 박신우
//		학년(숫자만) : 3
//		반(숫자만) : 4
//		번호(숫자만) : 15
//		성별(M/F) : F
//		성적(소수점 아래 둘째자리까지) : 85.75
//		3학년 4반 15번 박신우 여학생의 성적은 85.75이다.

	public void method5() {
		Scanner sc5 = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc5.nextLine();
		System.out.print("학년 : ");
		int grade = sc5.nextInt();
		System.out.print("반 : ");
		int ban = sc5.nextInt();
		System.out.print("번호 : ");
		int number = sc5.nextInt();
		System.out.print("성별 : ");
		String gender = sc5.next();
		System.out.print("성적 : ");
		double score = sc5.nextDouble();

		if (gender.equals("M")) { // String은 객체여서 equals()로 비교해야 한다
			System.out.println(grade + "학년 " + ban + "반 " + number + "번 " + name + " 남학생의 " + "성적은 " + score + "이다");
		} else {
			System.out.println(grade + "학년 " + ban + "반 " + number + "번 " + name + " 여학생의 " + "성적은 " + score + "이다");
		}

	}
//		나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지,
//		성인(19세 초과)인지 출력하세요.
//
//		ex.
//		나이 : 19
//		청소년

	public void method6() { // 메소드를 생성해야지 뭘 실행하지
		Scanner sc6 = new Scanner(System.in); // Scanner를 소환해야 뭘 적지
		System.out.print("나이 : ");
		int age = sc6.nextInt();

		if (age <= 13) {
			System.out.println("어린이(13세 이하)");

		} else if (age <= 19) {
			System.out.println("청소년(13세 초과 ~19세 이하");
		} else {
			System.out.println("19세 초과");
		}
	}
//	주민번호를 이용하여 남자인지 여자인지 구분하여 출력하세요.
//
//	ex.
//	주민번호를 입력하세요(- 포함) : 132456-2123456
//	여자

	public void method8() {
		Scanner sc8 = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요(- 포함) :");
		String num = sc8.nextLine(); //sc8에 있는 전체를 스트링 num에 넣어줄게?
		
		char gender = num.charAt(7);
											 // '==' 두 개 다 같아야지 참
		if(gender == '1' || gender == '3') { // '||' 두 항중에 하나의 항만 참이면 참
			System.out.println("남자");
		}else if(gender == '2' || gender == '4') {
			System.out.println("여자");
		}else {
			System.out.println("알 수 없음");
		}
	}
	
	
	
	
	
	

}
