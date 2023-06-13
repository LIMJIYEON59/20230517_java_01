package kh.lclass.tcp;

public class ServerMain {	//class서버 Main 생성
	public static void main(String[] args) {
		// 1. 서버의 포트번호 정함 ==> 프로그램의 포트번호
		new TcpServer().tcpTcpServer(9001);
	}

}
