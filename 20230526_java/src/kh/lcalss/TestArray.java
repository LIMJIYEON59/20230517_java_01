package kh.lcalss;

import java.util.Arrays;

public class TestArray {
	public static void main(String[] args) {
		String[] strArr = new String[3];
		strArr[0] = "apple";
		strArr[1] = "banana";
		strArr[2] = new String("mango");
		
		//strArr을 복사할 StrCopyArr생성
		String[] strCopyArr = new String[strArr.length]; // . length =3
		for(int i=0; i < strArr.length; i++ ) {
			strCopyArr[i] = strArr[i];
		}
		strArr[2] ="orange";
		strCopyArr[1] = "딸기";
		for(int i=0; i < strArr.length; i++) {
			System.out.println(strArr[i] +" : " + strCopyArr[1]);
		}
		System.out.println("==== ====");
		
		int a = 10;
		//a.
		int[] arrA = new int[3];
		arrA[2] = 20;
		int[] arrB = arrA.clone();
		System.out.println(arrB.length);
		System.out.println(arrB[2]);
		
		System.out.println("===Arrys. copyOf===");
		String[] strCopyArr2 = Arrays.copyOf(strArr, 3);
		System.out.println(strCopyArr2.length);
       		for(int i=0; i<strCopyArr2.length; i++) {
			System.out.println(strCopyArr2[i]);
		}
       		
       System.out.println("=== System ===");
       String[] strCopyArr3 = new String[5];
       System.arraycopy(strArr, 0, strCopyArr3, 3, 6);
       for(int i=0; i<strCopyArr3.length; i++) {
			System.out.println(strCopyArr3[i]);
		}
       
		

		
		
		
		//여러가지 방법
		String[] strArr2 = {"apple","banana", new String("mango")};
		String[] strArr3 = {new String("apple"), new String("banana"), new String("mango")};
		String[] strArr4 = new String[]{"apple", "banana", new String("mango")};
		String[] strArr5 = new String[]{new String("apple"), new String("banana"), new String("mango")};
		
		System.out.println("strArr의 1번째 과일은 "+strArr[0]);
		System.out.println("strArr의 1번째 과일은 "+strArr[1]);
		System.out.println("strArr의 1번째 과일은 "+strArr[strArr.length-1]);
		
//		for(int i=0; i <= strArr.length; i++)
		for(int i=0; i < strArr.length;  i++) {
			System.out.println("strArr의" + i + "번째 과일은 "+strArr[i]); //방법1
			System.out.printf("strArr의 %d번째 과일은 %s\n" ,i, strArr[i]); //방법2 포메티드?
			
		}
		
		
		
		//IndexOutOf어쩌구(오류) =>System.out.println(strArr[3]);
		
		int[] intArr = new int[3];
		System.out.println(intArr[1]);
		
		int[] intArr2 = new int[] {1,2,3};	//new int[]<안에 갯수를 적으면 안됨
		int[] intArr3 = {1,2,3};	//이렇게도 가능 그치만 위에놈으로 기억하기
		
		//student[] studentArr = new
				
				
				
	}

}
