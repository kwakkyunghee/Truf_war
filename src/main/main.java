package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class main{
	public static void main(String[] args){
		game_Frame fms = new game_Frame();
	}
}
class game_Frame extends JFrame implements KeyListener, Runnable{
	int f_width ;
	int f_height ;
	 
	int x, y; 
	boolean KeyUp = false;
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	boolean KeySpace = false;
	//�̻��� �߻縦 ���� Ű���� �����̽�Ű �Է��� �߰��մϴ�.

	Thread th;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image me_img;
	Image Missile_img; //�̻��� �̹��� ����
	ArrayList Missile_List = new ArrayList();
	//�ټ��� �̻����� �����ϱ� ���� �迭

	Image buffImage; Graphics buffg;

	Missile ms; // �̻��� Ŭ���� ���� Ű

	game_Frame(){
	init();
	start();
	  
	setTitle("���� ���� �����");
	setSize(f_width, f_height);
	Dimension screen = tk.getScreenSize();

	int f_xpos = (int)(screen.getWidth() / 2 - f_width / 2);
	int f_ypos = (int)(screen.getHeight() / 2 - f_height / 2);

	setLocation(f_xpos, f_ypos);
	setResizable(false);
	setVisible(true);
	}
	public void init(){ // ���Ǹ� ���� init ���� �⺻���� ������ �մϴ�.
	x = 100;
	y = 100;
	f_width = 800;
	f_height = 600;

	me_img = tk.getImage("alpaka.jpg"); 

	Missile_img = tk.getImage("chim.jpg");
	//�̻��� �̹����� �ҷ��´�.


	}
	public void start(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	addKeyListener(this);
	th = new Thread(this); 
	th.start(); 

	}

	public void run(){ 
	try{ 
	while(true){
	KeyProcess(); 

	MissileProcess(); //�̻��� ó�� �޼ҵ� ����

	repaint(); 
	Thread.sleep(20); 
	}
	}catch (Exception e){}
	}

	public void MissileProcess(){ // �̻��� ó�� �޼ҵ�
	if ( KeySpace ){ // �����̽��� Ű ���°� true ��
	ms = new Missile(x, y); // ��ǥ üũ�Ͽ� �ѱ��
	Missile_List.add(ms);    // �ش� �̻��� �߰�
	}
	}


	public void paint(Graphics g){
	buffImage = createImage(f_width, f_height); 
	buffg = buffImage.getGraphics();

	update(g);
	}

	public void update(Graphics g){
	Draw_Char();

	Draw_Missile(); // �׷��� �̻��� ������ ����

	g.drawImage(buffImage, 0, 0, this); 
	}

	public void Draw_Char(){ 
	buffg.clearRect(0, 0, f_width, f_height);
	buffg.drawImage(me_img, x, y, this);
	}

	public void Draw_Missile(){ // �̻��� �׸��� �޼ҵ�
	for (int i = 0 ; i < Missile_List.size()  ; ++i){
	//�̻��� ���� ������ Ȯ���Ѵ�.

	ms = (Missile) (Missile_List.get(i)); 
	// �̻��� ��ġ���� Ȯ��

	buffg.drawImage(Missile_img, ms.pos.x + 150, ms.pos.y + 30, this); 
	// ���� ��ǥ�� �̻��� �׸���.
	// �̹��� ũ�⸦ ������ �̻��� �߻� ��ǥ�� ������.

	ms.move();
	// �׷��� �̻����� ������ ���ڸ�ŭ �̵���Ű��

	if ( ms.pos.x > f_width ){ // �̻����� ȭ�� ������ ������
	Missile_List.remove(i); // �̻��� �����
	}
	}
	}

	public void keyPressed(KeyEvent e){
	switch(e.getKeyCode()){
	case KeyEvent.VK_UP :
	KeyUp = true;
	break;
	case KeyEvent.VK_DOWN :
	KeyDown = true;
	break;
	case KeyEvent.VK_LEFT :
	KeyLeft = true;
	break;
	case KeyEvent.VK_RIGHT :
	KeyRight = true;
	break;

	case KeyEvent.VK_SPACE : // �����̽�Ű �Է� ó�� �߰�
	KeySpace = true;
	break;
	}
	}
	public void keyReleased(KeyEvent e){
	switch(e.getKeyCode()){
	case KeyEvent.VK_UP :
	KeyUp = false;
	break;
	case KeyEvent.VK_DOWN :
	KeyDown = false;
	break;
	case KeyEvent.VK_LEFT :
	KeyLeft = false;
	break;
	case KeyEvent.VK_RIGHT :
	KeyRight = false;
	break;

	case KeyEvent.VK_SPACE : // �����̽�Ű �Է� ó�� �߰�
	KeySpace = false;
	break;

	}
	}
	public void keyTyped(KeyEvent e){}
	public void KeyProcess(){

	if(KeyUp == true) y -= 5;
	if(KeyDown == true) y += 5;
	if(KeyLeft == true) x -= 5;
	if(KeyRight == true) x += 5;
	}
	}

	class Missile{ // �̻��� ��ġ �ľ� �� �̵��� ���� Ŭ���� �߰� 

	Point pos; //�̻��� ��ǥ ����
	Missile(int x, int y){ //�̻��� ��ǥ�� �Է� �޴� �޼ҵ�
	pos = new Point(x, y); //�̻��� ��ǥ�� üũ
	}
	public void move(){ //�̻��� �̵��� ���� �޼ҵ�
	pos.x += 10; //x ��ǥ�� 10��ŭ �̻��� �̵�
	}
	}