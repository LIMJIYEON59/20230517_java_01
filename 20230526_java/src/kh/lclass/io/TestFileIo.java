package kh.lclass.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileIo {
	public void testFile() /* throws Exception */ {
//		File f1 = new File("D: /data1/aaa.txt");
//		f1.mkdirs();
		String path = "D:/data2/test";
		String filename = "aaa.txt";

		new File(path).mkdirs(); // 디렉토리 생성
		File f2 = new File(path, filename);
//		Unhandled exception type IOException 
		FileWriter fw = null;	 // 필드 외에는 무조건 초기값을 넣고 시작한다.
		try {
			f2.createNewFile(); // 파일생성

			fw = new FileWriter(f2); // fw선언
			fw.write("abcdefg");
			fw.flush();			 // 밖으로 나가도록 해줘야함
			return;
		} catch (IOException e) {
			System.out.println("file 생성 못함");
			e.printStackTrace();
		} finally { //가독성 Finally
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}