package kh.lclass.chat.client;

//결과값 돌릴 때 serverRun=>ClientRun=>ClientRun

import javax.swing.JOptionPane;

//밑에 확인이 보여지는 창 = alert()(리턴값이 없음 void 확인을 누루면 끝)
//예or아니오(확인,취소)같이 보여지는 창 = confirm()(true false)
//입력창(커서 깜빡)+ 확인 = prompt()(String)

public class ClientRun {
	public static void main(String[] args) {
		//사용자 nickname을 GUI를 통해서 입력받음
		String nickName = JOptionPane.showInputDialog("닉네임을 입력해주세요.");
		new ClientGUI(nickName); 

	}
}
