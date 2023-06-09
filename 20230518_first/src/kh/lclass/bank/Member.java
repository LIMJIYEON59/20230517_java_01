package kh.lclass.bank;

import java.util.Scanner;

public class Member {
	public static void main(String[] args) {
		//스캐너 마련
		java.util.Scanner sc = new Scanner(System.in);
		
		System.out.println("통장개설을 원하십니까?");
		String answer = sc.nextLine();
		if(answer.equals("네")) {		//(answer =="네") 문자 == 비교할 수 없음.
			
			System.out.println("주민번호 확인 : ");
			String strNo = sc.nextLine();
//			int strNo = sc.nextInt(); sc.nextLine();
			int sno = Integer.parseInt(strNo);	//10진수 정수로 바꿔준다.
			
			System.out.println("이름 확인 : ");
			String strName = sc.nextLine();
			BankAccount ej = new BankAccount(sno, strName);
			BankAccount hj = new BankAccount(123123, "종호", 1013333444);
			
			BankAccount jh = new BankAccount();
			System.out.println(jh.getSno());
			System.out.println(jh.getName());	
			System.out.println(jh.getBalance());	
			System.out.println(jh.getAccountName());
			jh.sumArgs(2, 5, 3);
		
			jh.sum(1, 3);
			jh.sum(1, 3,3);
			
			//String
			String str1 = "문자";
			String str2 = "문자";
			String str3 = new String();
			String str4 = new String("문자");
			System.out.println(str1);
			System.out.println(str2);
			System.out.println(str3); //nu11 //주소값 //""
			System.out.println(str4);
			
			boolean b = str1.equals(str4);
			if(str1.equals(str4)) System.out.println("같다"); //{ 중괄호 안에 한줄밖에 없다면 괄호 삭제가능
			else 				  System.out.println("다르다");	
			
			System.out.println(hj);
			System.out.println(hj.toString());
			System.out.println(hj.hashCode());
			
			System.out.println(hj.getSno().MAX_VALUE);
			System.out.println(hj.getSno().toHexString(sno));
			System.out.println("끝");
			
		} else {
			System.out.println("다른 창구를 이용해주세요");
		}	
	
		
		char c = '\'';
		System.out.println("한줄\n한탭\t탭한슬래쉬\\\\따옴표는 어떻게\"?");
		System.out.println("한줄\n한탭\t탭한슬래쉬\\\\따옴표는 어떻게\"?"); 
			
		System.out.println("안"+2+4); //안24
		System.out.println(2+4+"안"); //6안
		System.out.println(2+4+"안"); //8안
		System.out.println("안"+2*4); //안8
		System.out.println("안"+2*4+7); //안87
		System.out.println(2+4+"안"+7+8); //6안 7
		System.out.println(2+4+"안"+(7+8)); //6안15
		
		String str = "Hello Java";
		System.out.println(str.indexOf(' '));
		
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));
		System.out.println(str.length());
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		String strReplace = str.replace('J','L');
		System.out.println(strReplace);
		int idx = str.indexOf(' ');
		String strSubString = str.substring(
											str.indexOf(' ')+1, 
											str.indexOf(' ')+2
											);
		System.out.println(strSubString);
		
		for (int i = 5; i < str.length(); i++) {
			
		}
		if(str.length() < 3) {
			
		} else {
			System.out.println("다른 창구를 이용해주세요.");
			
		}
		
		
		
		
	}
}
