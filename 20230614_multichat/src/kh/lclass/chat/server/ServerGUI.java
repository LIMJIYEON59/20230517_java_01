package kh.lclass.chat.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class ServerGUI extends JFrame implements ActionListener{
	//컴파일 시 인식할 ServerGUI으로 만들어진 객체 고유 ID
	private static final long serialVersionUID = 6085316166659427339L;
	
	private JTextArea jta = new JTextArea(40, 25);	//채팅창 (세로 40)
	private JTextField jtf = new JTextField(25);	//글 입력 부분	(글자 입력칸)
	private ServerBackground sb = new ServerBackground();
	public ServerGUI() { //생성자
		//생성자에서는 초기화(즉 화면 초기화) //필드(jta,jtf 초기값 설정)
		setBounds(200,100,400,600);	//창이 뜨는 위치와 크기
		setTitle("서버창");
		
		jta.setEditable(false);	//채팅창은 입력되지 않도록 함
		jta.setFont(new Font("맑은고딕", Font.PLAIN,18)); //글자 폰트, 크기
		jta.setBackground(new Color(230, 255, 230));	//RGB컬러 색깔
		
		add(jta,BorderLayout.CENTER);
		add(jtf,BorderLayout.SOUTH);
		jtf.addActionListener(this); //this라는 객체를 적어야하는데(즉, new해서~) 위에 imple A한다(따로 class 작성x)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		sb.setGui(this); //여기선 닉네임 설정할 필요없다
		sb.setting();
	}
	//TODO 새 메시지를 받았을때 메소드 호출됨
	public void appendMsg(String msg) {
		// jta(채팅창)에 msg를 추가함
		jta.append(msg);
		jta.append("\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//입력창에 글 입력하고 enter key를 눌렀을때
		String msg = jtf.getText();
		System.out.println(msg);	//이래하면 text에 뜸
		jtf.setText(""); //입력창 입력된 글을 초기화(입력하고 엔터를 치면 글이 사라짐)
		//TODO client 들에게 전달함. background에 전달
		
		
	
		
		
	}

}
