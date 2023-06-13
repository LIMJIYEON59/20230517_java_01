package kh.lclass.tcp;

//Server는 포트번호를 못 박고 시작 CloentMain은 남는 포트 아무거나 씀(run시키면 포트 있음) => 프로세스간의 통신(포트와 포트끼리 통신)

public class ClientMain {
	public static void main(String[] args) {	//내부와 외부 ip가 존재한다.
		// 127.0.0.1 은  "localhost" = loopback	 //현재 이 pc에 접속하겠다.(localhoset)
		new TcpClient().testTcpClient("127.0.0.1", 9001);
	}

}
