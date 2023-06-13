package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public void testTcpClient(String ip, int port) { //serverIp, server port
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		//서버용 소켓은 쓰지 않는다.

		//console에 입력한 문자 읽어들이기 위한 객체 2가지
		// 방법1
		//Scaner sc = new Scanner(System.in)
		//Scanner와 유사한 기능
		// console에 입력한 문자 읽어들이기 위한 객체: 1.스캐너 2.밑에
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));	//생성할땐 t-c안묶여도된다. 
		// Input-- 안에 System을 넣어주게 되면 stdIn으로 부터 read를 하게되면 콘솔창에 입력한 것이 화면에 나타난다.//stdIn도 closed를 해줘야한다.
		
		try {

			// 1. 서버의 IP 주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
			socket = new Socket(ip, port);
			System.out.println("서버에 접속 성공");
			System.out.println("서버에 접속 성공");

			// 2. 연결된 클라이언트와 입출력 스트림 생성
			in = socket.getInputStream();	//get이 리턴하는 자료형은 InputStream이다
			out = socket.getOutputStream();
			// 3. 보조 스트림을 통해 성능 개선(보조 스트림 2개 단 거)
			br = new BufferedReader(new InputStreamReader(in));// 문자단위로 읽고 쓰기 위해 Reader 사용 ()안에 Reader형태가 있어야 해서 InP적음 
			pw = new PrintWriter(new OutputStreamWriter(out));//BufferedWriter말고 BufferedWriter를 쓰겠다.(wr=>pw 죄다 바꿔주기)
			//br = new BufferedReader(new InputStreamReader(socket.getInputStream())); <=이렇게 줄일 수 있다.
			//pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream));
			
			
			
			
			String sendMsg = null;
			while(true) {
				System.out.print("메시지>>");
				//console에 입력한 문자 읽어들이기
				sendMsg = stdIn.readLine(); 
				System.out.println("######" + sendMsg);
				//server로 문자 전송
				pw.println(sendMsg); // 줄바꿈 표시를 하나 붙여서 보내준다(println)
				pw.flush();
				//server로 부터 메시지 읽기
				String receiveMsg = br.readLine();
				System.out.println("서버로부터받은메시지: " + receiveMsg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stdIn !=null) stdIn.close();
				if (pw != null) pw.close();
				if (br != null) br.close();
				if (out != null) out.close();
				if (in != null) in.close();
				if (socket != null) socket.close();

			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
