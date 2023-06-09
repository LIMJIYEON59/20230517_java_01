package kcom.kh.practice1.func;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 가져다가 전원버튼 누름 스캐너도로록 주면 pc가 도로록 저장
		 
		//enter key를 눌릴 때 까지의 데이터를스캔해줘
		// 1 2 가 나 다 enter 
		// scan은 데이터 "11 22 33 가가가 나나 다 \n\0" (1 2 3 가 나 다 등등)을 다 가지고 있다. (\n 줄바꿈)
		String str1 = scan.next();  // 띄워쓰기 또는 enter 전까지 한덩어리 문자형태리턴 (니가 가지고 있는 데이터 중에 한 덩어리만 줘) String
		System.out.println(str1);//11
		int num1 = scan.nextInt();  // 띄워쓰기 전까지 한덩어리를 정수로 바꿔서 리턴 /int
		System.out.println(num1);//22
		double num2 = scan.nextDouble(); // 띄워쓰기 전까지 한덩어리를 실수로 바꿔서 리턴 /double
		System.out.println(num2);//33.0
		String str2 = scan.nextLine(); // 줄바꿈까지의(전x) 덩어리를 문자형태로 바꿔서 리턴 /String
		System.out.println(str2);// 가가가 나나 다 \n
		
		System.out.println("입력1");
		int num3 = scan.nextInt();
		scan.nextLine(); //flush()
		System.out.println(num3);
		
		System.out.println("입력2");
		String str3 = scan.nextLine();
		System.out.println(str3);
		
		System.out.println("끝");
		
		
		
		
		scan.close();

	}

}
