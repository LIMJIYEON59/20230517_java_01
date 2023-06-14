package kh.lclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoReceiver {
	public static void main(String[] args) {
		new UdpEchoReceiver().receiverUdp();
	}
	public void receiverUdp() {
		//포트번호 정함
		int myPort = 6001;
//		int destPort = 6001;
//		String destName = "localhost";
		DatagramSocket dSock = null;
			try {
				// DatagramSocket 객체 생성
				dSock = new DatagramSocket(myPort);	//6001번을 통해서 만들어진 dSock
				
				//메시지 수신
				while(true) {
					byte[] byteMsg = new byte[1000]; //개수 정해야함
					//수신받을 메시지를 DatagramPacket 객체에 담음
					 DatagramPacket receivedData 
					 = new DatagramPacket
					 (byteMsg, byteMsg.length); //수신용은 바이트배열과 길이만 알려주면된다
					  dSock.receive(receivedData);
					  
//					  //전달받은 메시지 정보들
//					  System.out.println("===전달받은 정보들==");
//					  System.out.println(byteMsg.length);
//					  System.out.println(receivedData.getData().length);
//					  System.out.println(receivedData .getLength());    //전달받은 메시지의 발신 ip
//					  System.out.println(receivedData.getAddress());	//전달받은 메시지읜 발신 port
//					  System.out.println(receivedData.getPort());
					  
					  String receivedStr = new String(receivedData.getData());// String str = "aaa";  String str2 = new String();
					  System.out.println("수신메시지:" + receivedStr);
					  	
					  //Echo 메시지 송신
					  	//(위에서 받은 메세지를 다시 송신하겠다. 송신하려면 상대방 아이디/상대방에게 메세지를 전달 할 바이트 배열/DatagramPacket이 있어야 한다.)
//					  5. 전송할 메시지를 DatagramPacket 객체에 담음
					  DatagramPacket sendData 
					  = new DatagramPacket
					  (receivedData.getData(), receivedData.getLength()
								 , receivedData.getAddress(), receivedData.getPort());
						 dSock.send(sendData);
						 //즉, 수신받았던 데이터 넣고 길이 넣고 주소 넣고 포트 넣고 끝
						//다시 상대방에게 전달 할 메세지:receivedData.getData();이다. 문제는 receivedData.getData의 길이는?
						//receivedData.getData().length의 길이는 1000,receivedData.getLength()의 길이는 갯수로 나옴
						//receivedData이 데이터 안에 getAddress() 주소(ip) 있고 Port도 있다
				
				}
				
				
				
				
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		
			
			 

		}
  	}

