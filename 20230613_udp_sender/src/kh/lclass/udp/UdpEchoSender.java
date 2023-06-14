package kh.lclass.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

//송신용
public class UdpEchoSender {
	public static void main(String[] args) {
		UdpEchoSender instance = new UdpEchoSender();
		instance.senderUdp();
	}

	public void senderUdp() {
		// 포트번호 정함
		int myPort = 5001;
		int destPort = 6001;
		String destName = "localhost";	//127.어쩌구 선언 해서 대입 
		
		// DatagramSocket 객체 생성
		DatagramSocket dSock = null; //밖에다가 선언
		BufferedReader br = null;
		try {									  //dSock 앞에 대입
			dSock = new DatagramSocket(myPort); 	//매개인자 안 적으면 자동 Port 번호생성됨. 지정하면 해당 포츠번호로 소켓 생성
			
			br = new BufferedReader(new InputStreamReader(System.in));	//system이 기반스트림 역할 함 //선언밖에다가 하기 //+2
			while(true) {	//+
				//전달할 메시지 //+2
				System.out.println("입력>>");
				String sendMsg =br.readLine(); //console 입력받음
				// exit 입력하면 프로그램 끝내기
				if(sendMsg.equals("exit")) {
					break;
				}
			
				//메시지 전달!(하기 위해서는 DatagramPacket 필요 5번 말), 밖에다 선언(안에다 선언해도됨 finally없어서)
				InetAddress destIp = null;
				try {
//					 3. 연결한 클라이언트 IP주소를 가진 InetAddress 객체 생성
					 destIp = InetAddress.getByName(destName);// 여기다 넣기
	//				 4. 전송할 메시지를 byte[]로 바꿈
					 byte[] byteMsg = sendMsg.getBytes();
//					 5. 전송할 메시지를 DatagramPacket 객체에 담음
					 DatagramPacket sendData = new DatagramPacket(byteMsg, byteMsg.length, destIp, destPort); //byte넣고,길이정하고	 
					 
//					 6. 소켓 레퍼런스를 사용하여 메시지 전송
					 dSock.send(sendData);	 	 
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//메시지 수신! //+2
		    		byte[] byteMsg = new byte[1000]; //개수 정해야함	//byte를 받을 비어있는 텅 빈 byte 배열를 만든다. 
		    		//수신받을 메시지를 DatagramPacket 객체에 담음
		    		DatagramPacket receivedData 
		    		= new DatagramPacket							//그것은 DatagramPacket에 넣는다.
		    		(byteMsg, byteMsg.length);
		    		dSock.receive(receivedData);
				 
//		    		//전달받은 메시지 정보들								//그리고나서 그 메세지들을 뿌린다.
//		    		System.out.println("===전달받은 정보들==");
//		    		System.out.println(byteMsg.length);
//		    		System.out.println(receivedData.getData().length);
//		    		System.out.println(receivedData .getLength()); //전달받은 메시지의 발신 ip
//		    		System.out.println(receivedData.getAddress());	//전달받은 메시지읜 발신 port
//		    		System.out.println(receivedData.getPort());
		    		String receivedStr = new String(receivedData.getData());// String str = "aaa";  String str2 = new String();
		    		System.out.println("Echo메시지:" + receivedStr);
			}
		} catch (SocketException e) { //SocketException 
			e.printStackTrace();
		} catch (IOException e) {	//+2
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close(); //+2
			} catch  (IOException e) {
				e.printStackTrace();
			}
			if(dSock != null) dSock.close(); // IO어쩌구 안 뜨지만 이거 적어서 if(dSock != null) 오류 대비
		}
		
	}
}
