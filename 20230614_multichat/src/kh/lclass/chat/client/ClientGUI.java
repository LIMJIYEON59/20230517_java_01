package kh.lclass.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 6521300218799647804L;
	private JTextArea jta = new JTextArea(40, 25); //이름 굳이 다를 필요x
	private JTextField jtf = new JTextField(25);	
	
	private String nickName;
	private ClientBackground cb = new ClientBackground();	//채팅socket 기능을 담당할 객체
	
	
	public ClientGUI(String nickname) { //접속할 때 닉네임 가지고 들어오니 닉네임 설정해준다.
		this.nickName = nickname;
		
		//생성자에서는 초기화(즉 화면 초기화)
		setBounds(200,100,400,600);	
		setTitle(nickname +"님 창");	
		
		jta.setEditable(false);	//채팅창은 입력되지 않도록 함
		jta.setFont(new Font("맑은고딕", Font.PLAIN,18)); //글자 폰트, 크기
		jta.setBackground(new Color(230, 255, 230));	//RGB컬러 색깔
	
	
	
		add(jta,BorderLayout.CENTER);
		add(jtf,BorderLayout.SOUTH);
		jtf.addActionListener(this); //this라는 객체를 적어야하는데(즉, new해서~) 위에 imple A한다(따로 class 작성x)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
		cb.setNickname(nickname);
		cb.setGui(this);
		cb.connection();
	}
	//TODO	새 메시지를 받았을때 메소드 호출됨
	public void appendMsg(String msg) {//메소드 열어 리턴x 서버도 메소드 열어야함
		// jta(채팅창)에 msg를 추가함
		jta.append(msg);
		jta.append("\n");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = jtf.getText();
		System.out.println(msg);	//이래하면 text에 뜸 //buff-\n 추가 //print쓰면 \n추가안해도됨
		jtf.setText(""); 
		// server에 전달함. background에 전달
		cb.sendMessage(msg);
	}
	
	

	
	
	
		
	}


