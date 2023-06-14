package kh.lclass.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InnerClassListener extends JFrame{	//상속
	public InnerClassListener() {	//생성자 생성
		setTitle("Action 이벤트 리스너 예제");		//창의타이틀 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//창을 닫을 때 프로그램 종료
		Container c = getContentPane();	//컨텐츠 영역을 가져온다
		c.setLayout(new FlowLayout());	//컨텐츠 영역의 레이아웃을 'FlowLayout'으로 설정
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		setSize(350,150);
		setVisible(true);
		
	}
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
				b.setText("액션");
			else
				b.setText("Action");
			InnerClassListener.this.setTitle(b.getText());
		}
		
	}
	public static void main(String[] args) {
		new InnerClassListener();
	}
}
