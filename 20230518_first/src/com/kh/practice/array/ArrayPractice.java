package com.kh.practice.array;

import java.util.Scanner;

public class ArrayPractice {
//	메소드 명 : public void practice1(){}
//	길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여
//	순서대로 배열 인덱스에 넣은 후 그 값을 출력하세요.
//
//	ex.
//	1 2 3 4 5 6 7 8 9 10

	
	public void practice1() {
		int[] num = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i]+ " ");
		}
	
	}
	
	
//		메소드 명 : public void practice2(){}
//		길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여
//		역순으로 배열 인덱스에 넣은 후 그 값을 출력하세요.
//
//		ex.
//		10 9 8 7 6 5 4 3 2 1
	
	public void practice2() {
		int[] Array = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		for(int i = 0; i < Array.length; i++) {
			 Array[i] = 10-i;
			System.out.print(Array[i]+ " ");
		}
	}
	
//	사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
//	1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
//
//	ex.
//	양의 정수 : 5
//	1 2 3 4 5
	 public void practice3(){
		 Scanner sc = new Scanner(System.in); //임포트 꼭 해준다.
		 System.out.print("양의 정수 : "); //출력을 했으면
		 int num = sc.nextInt(); 		// (맞는)자료형 변수이름 = 스캐너 이름.(다 받는다)next(맞는 놈)
		 
		 int[] numArray = new int[num];
		 
		 for(int i=0; i <numArray.length; i++) {
			 numArray[i] = i+1;			//이걸 적으니깐 나옴 (원래는 00000)
			 System.out.print(numArray[i]+" ");
		 }
	 }
	 
//	 메소드 명 : public void practice4(){}
//	 길이가 5인 String배열을 선언하고 “사과”, “귤“, “포도“, “복숭아”, “참외“로 초기화 한 후
//	 배열 인덱스를 활용해서 귤을 출력하세요.
//
//	 ex.
//	 귤

	 public void practice4() {
//		 길이가 5인 String배열을 선언한다 = 자료형[] 변수이름 = {----};
		 String[] fruitArray = {"사과","귤","포도","복숭아","참외"};
		 System.out.println(fruitArray[1]); //출력한다 변수이름[-]
		 
		 }
	
//	 메소드 명 : public void practice5(){}
//	 문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지
//	 개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
//
//	 ex.
//	 문자열 : application
//	 문자 : i
//	 application에 i가 존재하는 위치(인덱스) : 4 8
//	 i 개수 : 2
	 
	 public void practice5() {
		 Scanner sc = new Scanner(System.in);
		 System.out.print("문자열 : ");
		 String str = sc.nextLine();
		 System.out.print("문자 : ");
		 char ch = sc.nextLine().charAt(0); //chatAt(0) => String 으로 저장된 문자열 중에서 
				 						    // 한 글자만 선택해서 char타입으로 변환해주는 녀석
		 
		 int count = 0;
	
		 
		 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
}