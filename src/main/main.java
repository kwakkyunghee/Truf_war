package main;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JFrame {
	/*생성자입니다.*/
	public main() {
		homeframe();
	}
	public void homeframe() {
		setTitle("truf_war");//창의 타이틀
		setSize(1000,700);//프레임의 크기
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setLayout(null);
		setVisible(true);//창이 보이게	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
	}
	public static void main(String[] args){
		new main();
	}
//	static JPanel page1=new JPanel();
//	Image background=new ImageIcon(Main.class.getResource("../image/background1.png")).getImage();
//	public void paint(Graphics g) {//그리는 함수
//		g.drawImage(background, 0, 0, null);//background를 그려줌		
//	}
//};
}

