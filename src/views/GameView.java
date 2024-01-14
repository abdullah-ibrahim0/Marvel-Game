package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GameView extends JFrame{
	JPanel panel1;
	JPanel panel2;
	JLabel label;
	ImageIcon Img;
	JLabel label1;
	JLabel label2;
	JTextArea text1;
	JTextArea text2;
	public GameView() {
		this.setBounds(350,120, 800, 600);
		this.setVisible(true);
		this.setTitle("Marvel Ultimate War");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		label.setPreferredSize(new Dimension(getWidth(),getHeight()));
		Img = new ImageIcon(getClass().getResource("img.jpg"));
		label = new JLabel(Img);
		add(label);
	}
	public static void main(String[] args) {
		new GameView();
	}


}
