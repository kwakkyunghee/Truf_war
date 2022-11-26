package main;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class main_2 extends JFrame{
	public static void main(String[] args) throws IOException{
		File file = new File("background1.jpg");
		BufferedImage img = ImageIO.read(file);
		JLabel lb = new JLabel(new ImageIcon(img));
		JFrame f = new JFrame("truf_war");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(lb);
		f.pack();
		f.setLocation(500,500);
		f.setVisible(true);
	}
	
}
