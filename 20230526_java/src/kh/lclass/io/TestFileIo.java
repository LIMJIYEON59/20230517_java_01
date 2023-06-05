package kh.lclass.io;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import kh.lcalss.oo.sample.Person;
import kh.lclass.exception.UserException;

public class TestFileIo {
	public void testFileOutputStreamObject() {
		Person p1 = new Person("홍길동", 23, '남');
		Person p2 = new Person("영희", 27, 'F');

		String filePath = "D:/data2/test/aaa.txt";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filePath); // stream try 누르기^^ 3
			oos = new ObjectOutputStream(fos); // 2번째
			oos.writeObject(p1);// Object 해놓기
			oos.writeObject(p2); // Object 해놓기
			oos.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (oos != null)
					oos.close();
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void testFileInputStreamObject() {
		String filePath = "D:/data2/test/aaa.txt";
		FileInputStream ios = null; // 기반 스트림
		ObjectInputStream ois = null; // 보조 스트림
		try {
			ios = new FileInputStream(filePath); // stream try 누르기^^ 3
			ois = new ObjectInputStream(ios); // 2번째

			Object a = null;

			if ((a = ois.readObject()) instanceof Person) {
				Person p = (Person) a;
				System.out.println(p);
			}
			if ((a = ois.readObject()) instanceof Person) {
				Person p = (Person)a;
				System.out.println(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (ios != null)
					ios.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void testRamda() throws UserException {
		int[] arr = { 2, 3, 4 };
		int[] arr2 = new int[] { 2, 3, 4 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		if (arr.length > 2) {
			throw new UserException("배열의 크기는 2보다 크면 안됨. 줄여주세요.");
			// 오류 발생하고 죽어버림/
		}
	}

	public void testFileReadData() {
		String filePath = "D:/data2/test/aaa.txt";
		try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath));) {
			long temp = 0L;
			while ((temp = dis.readLong()) != 0) {
				System.out.println(String.valueOf(temp));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testFileRead3() {
		String filePath = "D:/data2/test/aaa.txt";
		try (FileInputStream fis = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);) {
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void testFileRead2() { // 지역변수 초기값 무조건
		// 보조스트림
		String filePath = "D:/data2/test/aaa.txt";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {

			// 생성 순서 : 기반스트림 => 보조스트림ㅁ
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
//			if(br == null) {
//				throw new NumberFormatException(); //기억하삼
//			}
			// 줄여서 나타내기
//			isr = new InputStreamReader(new FileInputStream(filePath));
//			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 해제 순서 (생성반대순서) : 보조스트림 => 기반스트림
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (fis != null)
					fis.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void testFileRead() {
		String filePath = "D : /data2/test/aaa.txt";
		// fr cannot be resolved
		FileReader fr = null; // 오류1 수정 밖에 내보냄
		try {
			fr = new FileReader(filePath); // (file과 java 프로그램의 resource 통로)
//			   Unhandled exception type IOException
//				사용 불가 for(int i=0; i<fr.)
			// 방법1
//				int a = -1;
//				while ((a = fr.read()) > -1) {
//					System.out.println((char)a);
//				}
			// 방법2
			int cntPerRead = 50;
			char[] readCharArr = new char[1000];
			for (int i = 0; i < readCharArr.length / cntPerRead; i++) {
				int readCnt = fr.read(readCharArr, i * cntPerRead, cntPerRead);
				System.out.println(readCnt); // 50 : 문자 4개 읽었음
				if (readCnt < cntPerRead) {
					break;
				}
			}
			System.out.println(readCharArr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다. 경로를 확인해 주세요");
		} finally {

			try {
				if (fr != null)
					fr.close(); // fr.close =>오류1: fr cannot be resolved
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();

			}

		}

		System.out.println("== testFileRead 끝 ==");
	}

	public void testFile() /* throws Exception */ {
//		File f1 = new File("D: /data1/aaa.txt");
//		f1.mkdirs();
		String path = "D:/data2/test";
		String filename = "aaa.txt";

		new File(path).mkdirs(); // 디렉토리 생성(파일 생성 코드)
		File f2 = new File(path, filename);
//		Unhandled exception type IOException 
		FileWriter fw = null; // 필드 외에는 무조건 초기값을 넣고 시작한다.
		try {
			f2.createNewFile(); // 파일생성

			fw = new FileWriter(f2); // File에 문자 형태(Writer) 전송이 가능한 OutpuStream (file과 java 프로그램의 통로
			fw.write("한글"); // 전송하고자 하는 문자
			fw.flush(); // 전송한 문자가 담긴 버퍼(통로)를 꺠끗하게 밀어내기(밖으로 나가도록 해줘야함)
			return;
		} catch (IOException e) {
			System.out.println("file 생성 못함");
			e.printStackTrace();
		} finally { // 가독성 Finally //return 전에 반드시 실행하고 넘어가는 문구
			try {
				if (fw != null)
					fw.close(); // 통로 닫기
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
} // 오류는 밑줄,run, //if문을 통해서 막는다. try catch를 통해서 막는다.