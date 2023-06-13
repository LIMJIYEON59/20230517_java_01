package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {	
	// 일반메소드(대,소문자 다름)
	// 1. 서버의 포트번호 정함 ==> 프로그램의 포트번호
	public void tcpTcpServer(int port) {	//그냥 메소드 소환(생성자 아님) 	//(int port) SM(클래스)의 포트번호를 받아오겠다.
		ServerSocket ss = null;	//서버용 소켓에는 2개가 있다. 서버용 소켓1(1개)
		Socket sc = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter wr = null;

		try {
			//Resource leak: '<unassigned Closeable value>' is never closed =>closed를 해라!
			// 2. 서버용 소켓 객체 생성
			ss = new ServerSocket(port);	//t-c 묶어주기 	// closed를 위해 ss에 서버소켓 대입	//서버용 소켓2(클라이언트가 들어올수록 늘어난다)
			System.out.println("서버(나의) 포트:" + ss.getInetAddress().toString()); // 0.0.0.0.0/0.0.0
			System.out.println("클라이언트 Port:" +ss.getLocalPort());
			
			//while문을 돌려서 1명이 아닌 여러명의 값을 받겠다.
			while (true) {

				System.out.println("클라이언트 접속 대기 중......");
				// 3. 클라이언트 쪽에서 접속 요청이 오길 기다림(3.4번이 같이 이뤄진다)
				// 4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
				//sc = ss.accept(); //ss.accept(); 기다림 =>리턴을 한다.	 //클라이언트와 소통하는 소켓 //Socket sc = ss.accept();인데 위에 선언을 해서 앞에놈 사라짐(밑에도 죄다)
				
				//System.out.println("클라이언트 접속됨:" + sc.getLocalPort());//누가 접속했다~ Client Ip를 적어보겠다.
				//System.out.println("클라이언트 접속됨:" + sc.getPort()); //(위아래) 이렇게 적으면 클라이언트에서 자동 생성된 포트번호가 뿌려진다
				sc = ss.accept();
				System.out.println("서버(나의) 포트:" + sc.getLocalPort());//9001
				System.out.println("클라이언트 Port:" + sc.getPort()); //자동바뀜
				System.out.println("클라이언트 IP:" + sc.getInetAddress().toString());

				// 5. 연결된 클라이언트와 입출력 스트림 생성
				in = sc.getInputStream();	//get이 리턴하는 자료형은 InputStream이다
				out = sc.getOutputStream();
				// 6. 보조 스트림을 통해 성능 개선(보조 스트림 2개 단 거)
				br = new BufferedReader(new InputStreamReader(in));// 문자단위로 읽고 쓰기 위해 Reader 사용 ()안에 Reader형태가 있어야 해서 InP적음 
				wr = new BufferedWriter(new OutputStreamWriter(out));

				String receivedMsg = null; //추가,선언 밖에다.		//readLine은 줄바꿈 표시가 있을 때까지 계속 대기(인풋 계속 받음)
				while ((receivedMsg = br.readLine()) != null) {//readLine은 pop개념으로 메세지를 읽은 다음에 버퍼에서 꺼낸 다음 버린다 
					System.out.println("받은메시지: " + receivedMsg);//그리고 그 메세지를 변수에 담아 담은 것이 널인지 체크하고 널이 아니라면 지금 메세지가 들어왔구나 라고 판단
					wr.write(receivedMsg+"메시지 잘 받았음.\n");	//메시지를 잘 받았을 떄
					wr.flush();
				}
			}


		} catch (IOException e) {
			e.printStackTrace();
		} finally {//finally 사용하여 close함
			try {
				//Input OutputStream에서 closed는 해줘야한다(역순으로)
				// Resource leak: '<unassigned Closeable value>' is never closed
				if (wr != null)	wr.close();//t-c 묶기, if사용하기	
				if (br != null) br.close();
				if (out != null) out.close();
				if (in != null)	in.close();
				if (sc != null)	sc.close();
				if (ss != null)	ss.close();	//선언한 모든 것들 t-c 밖으로 뺴내야 한다

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/* 소켓 프로그램은 코드가 간단하다
		 * ss = new ServerSocket(port);
		 * sc = ss.accept(); 이거 두 개밖에 없는데
		 * 코드가 긴 이유는 = try-catch가 있어줘야 하고 그러다보니 closed도 있어야 하고(각각) 또 선언을 밖에 해줘야함  
		 */

	}

}
