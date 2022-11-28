package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class ShootingGame extends JFrame{
	
	private Image bufferImage;
	private Graphics screenGraphic;
	
	private Image startScreen = new ImageIcon("start2.jpg").getImage();
	private Image ruleScreen = new ImageIcon("background1.jpg").getImage();
	private Image backgroundScreen = new ImageIcon("background1.jpg").getImage();
	
	private boolean isStartScreen, isRuleScreen, isBackgroundScreen;
	
	public static Game game = new Game();
	
	
	public ShootingGame() {
		setTitle("truf_war");
		setUndecorated(true);
		setSize(main.SCREEN_WIDTH,main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		init();
	}
	
	private void init() {
		isStartScreen = true;
		isRuleScreen = false;
		isBackgroundScreen = false;
		
		addKeyListener((java.awt.event.KeyListener) new KeyListener());
	}
	private void gameStart() {
		isStartScreen = false;
		isRuleScreen = true;
		
		Timer loadingTimer = new Timer();
		TimerTask loadingTask = new TimerTask() {
			@Override
			public void run() {
				isStartScreen = false;
				isRuleScreen = true;
			}
		};
		loadingTimer.schedule(loadingTask,3000);
		
		game.start();
	}
	
	public void paint(Graphics g) {
		bufferImage = createImage(main.SCREEN_WIDTH, main.SCREEN_HEIGHT);
		screenGraphic = bufferImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(bufferImage, 0, 0, null);
		
	}

	public void screenDraw(Graphics g) {
		if(isStartScreen) {
			g.drawImage(startScreen, 0, 0, null);
		}
		if(isRuleScreen) {
			g.drawImage(ruleScreen, 0, 0, null);
		}
		if(isBackgroundScreen) {
			g.drawImage(backgroundScreen, 0, 0, null);
			game.gameDraw(g);
		}
		
		this.repaint();
	}
	
	class KeyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				game.setUp(true);
				break;
			case KeyEvent.VK_S:
				game.setDown(true);
				break;
			case KeyEvent.VK_A:
				game.setLeft(true);
				break;
			case KeyEvent.VK_D:
				game.setRight(true);
				break;
				
			case KeyEvent.VK_ENTER:
				if(isStartScreen) {
					gameStart();
				}
				break;
			case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
			}
		}
		
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				game.setUp(false);
				break;
			case KeyEvent.VK_S:
				game.setDown(false);
				break;
			case KeyEvent.VK_A:
				game.setLeft(false);
				break;
			case KeyEvent.VK_D:
				game.setRight(false);
				break;
				
			}
		}
	}
}
