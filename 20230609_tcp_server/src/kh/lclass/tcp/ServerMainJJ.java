package kh.lclass.tcp;

public class ServerMainJJ {
	public static void main(String[] args) {
		//서버의 번호를 제일 먼저 정해줘야함 =>프로그램 번호
		new TcpServer().tcpTcpServer(5924);
	}

}
