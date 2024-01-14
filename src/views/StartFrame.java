package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import engine.Game;

public class StartFrame extends JFrame {
	JLayeredPane panel0;
	JLabel label0;
	ImageIcon img;
	JButton b;
	Game game;

	public StartFrame() {
		this.setBounds(125,75,1280,720);
		this.setVisible(true);
		this.setTitle("Marvel Ultimate War");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		panel0 = new JLayeredPane();
		b = new JButton("Start New Game !");
		b.setBackground(Color.BLACK);
		b.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
		b.setBounds(555, 110, 200, 70);
		b.setForeground(Color.RED);
		img = new ImageIcon(".\\assests\\mrvl.jpeg");
		label0 = new JLabel(img);
		label0.setBounds(0, 0,1280,720);
		panel0.add(b);
		panel0.add(label0);
		this.add(panel0);
		this.revalidate();
		this.repaint();
	}

	public static void main(String[] args) {
		new StartFrame();
	}

	public JButton getbutton() {
		return b;
	}


}
