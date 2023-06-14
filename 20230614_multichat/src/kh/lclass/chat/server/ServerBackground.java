package kh.lclass.chat.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServerBackground { // 클라이언트와 비교해서 클래스 이름이 달라지겠지
	private ServerSocket serverSocket; // 서버소켓이 무조건 있어함
	private ServerGUI gui; // null //=new 하면 안됨

	// client 여러명을 관리 : key:nickname, value: 객체를 넣어준다.
	private Map<String, BufferedWriter> mapClients = new HashMap<String, BufferedWriter>();
	// map.put("socket",socket);
	// map.put("nickname","ej");
	// mapList.add(map);

	// map.put("ej", socket);
	// map.put("hj", socket);

//<이거 없앰>	
	private Socket socket;
//	private BufferedReader br;
//	private BufferedWriter bw;

	private int count; // 현재 접속자 수

	// disconnection안 만든다 = 잘 꺼지지않아서.

	// 서버 생성 및 설정
	public void setting() { // 메소드 이름 걍 만듬
		//참고: 동시접속자로 map에 정보가 동기화되어 들어가도록 설정함.
		Collections.synchronizedMap(mapClients);
		try {
			serverSocket = new ServerSocket(7777);

			// !!Client 에 있던 번호랑 같아야함
			// 서버는 계속 돌아가야 하기 때문에 무한반복을 쓴다. break 없음(방문자 접속을 계속 받아들임. 무한반복함 GUI 프로그램경우 창 닫힐때까지 반복)
			while (true) {
				// 접속자 대기 중

				socket = serverSocket.accept(); //업셋을 하면 주고번지가 자동으로 socket에 들어온다.
				new Client(socket).start();
				
//				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 클라이언트 접속하면 그 정보를 나타내 주는 메소드
	public void addClient(String nickname) {
		gui.appendMsg(nickname + "님이 접속했습니다."); // gui야 이것좀 뿌려줘 닉네임뿐만 아니라 +---이것도.
	}

	public void setGui(ServerGUI gui) {
		this.gui = gui;
	}
	
	public void sendMessage(String msg) {
		// client를 모두에게 msg 전달
		Set<String> keys = mapClients.keySet();
		for(String key : keys) {
			BufferedWriter wr = mapClients.get(key);
			try {
				wr.write(msg+"\n");
				wr.flush();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
////////////////////////Inner Class///////////////////////////////
	
//그냥 소켓만 있었다면 괜찮았을텐데 메세지를 받는걸 계속할거기 때문에
	class Client extends Thread {
		private BufferedReader br;
		private BufferedWriter bw;
		private String nickname;
		public Client(Socket socket) {
			//초기값 설정
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				// 클라이언트 nickname이 바로 이어서 들어옴 (클라이언드와 약속이 돠어있음 서버접속=>바로 nickname)
				String nickname = br.readLine();	// 딱 하나 읽는데 닉네임
				//server 화면에 표현
				addClient(nickname); // 호출
				//client outputStream 관리 map에 추가
				mapClients.put(nickname, bw);
				//client map 모두에게 접속 정보 전달
				sendMessage(nickname+"님 접속했습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		@Override 
		public void run() {
			//클라이언트마다 각각에서 전달되어오는 메시지를 확인하고 화면에 출력
			//client와 입력통로가 끊어지지 않았다면 계속 반복확인함.
			//client에서 수신받은 msg(수신은 여기서 다 처리해준다)
			//반복문(무한반복)겁나 돌려
			while(br != null) {
				try {
					String msg = br.readLine();
					gui.appendMsg(msg);	
					//client map 모두에게 접속 정보 전달
					sendMessage(msg);
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}

































