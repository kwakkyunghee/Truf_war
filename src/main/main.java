package main;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JFrame {
	/*�������Դϴ�.*/
	public main() {
		homeframe();
	}
	public void homeframe() {
		setTitle("truf_war");//â�� Ÿ��Ʋ
		setSize(1000,700);//�������� ũ��
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setLayout(null);
		setVisible(true);//â�� ���̰�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
	}
	public static void main(String[] args){
		new main();
	}
//	static JPanel page1=new JPanel();
//	Image background=new ImageIcon(Main.class.getResource("../image/background1.png")).getImage();
//	public void paint(Graphics g) {//�׸��� �Լ�
//		g.drawImage(background, 0, 0, null);//background�� �׷���		
//	}
//};
}

