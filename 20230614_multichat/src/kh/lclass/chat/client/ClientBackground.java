package kh.lclass.chat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientBackground { //채팅이라 Tcp-통신함
	private Socket socket; //필드는 따로 close 안해줘도됨 disconne
	private BufferedReader br;
	private BufferedWriter bw;
	private String nickname;
	private ClientGUI gui; //null // =new 하면 안됨 
	
	
	//client가 서버에 접속(클라이언트가 접속하기 위한 메소드
	public void disconnection() {
		try {
			if(socket != null) {
				socket.close();
			}
		}catch (Exception e) {
			
		}
	}
	//필드는 따로 close 안해줘도됨 garbage collection에 의해 close됨
	public void connection() {
		try {	
			//서버와 연결
			socket = new Socket("127.0.0.1", 7777); //socket = new Socket("127.0.0.1", 7777); 이 모습에서 t-c
			// 서버와 입/출력 통로 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//접속되면 바로 나의 nickname 전송
			bw.write(nickname +"\n");
			bw.flush();
			
			//server와 입력 통로가 끊어지지 않았다면 계속 반복 확인함
			//server에서 수신받은 msg
			while(br != null) { //수신받은 메시지 처리
				String msg = br.readLine();
				gui.appendMsg(msg);
				
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void sendMessage(String msg) {
		// server에 msg 전달
		try {
			bw.write(nickname+":"+msg+"\n");
			bw.flush();
			gui.appendMsg(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//닉네임 setter
	public void setNickname(String nickName) {
		this.nickname = nickName;
	}
	//private ClientGUI gui;
	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}
}
	


