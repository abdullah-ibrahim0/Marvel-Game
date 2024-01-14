package views;

import java.awt.BorderLayout;
import views.*;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import engine.*;
import javax.swing.*;
import engine.Player;

public class GameFrame extends JFrame implements ActionListener {
	private JLayeredPane panel;
	private JLabel label;
	ImageIcon img;
	private JButton b;
    JTextField field1;
	JTextField field2;

	public GameFrame() {
		this.setBounds(350,145,800,610);
		this.setVisible(true);
		this.setTitle("Marvel Ultimate War");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		panel = new JLayeredPane();
		JLabel label1 = new JLabel("1st Player Name");
		JLabel label2 = new JLabel("2nd Player Name");
		field1 = new JTextField();
		field2 = new JTextField();
		label1.setBounds(30, 50, 150, 25);
		label2.setBounds(30, 90, 150, 25);
		label1.setForeground(Color.MAGENTA);
		label2.setForeground(Color.MAGENTA);
		field1.setBounds(170, 50, 130, 25);
		field2.setBounds(170, 90, 130, 25);
		b = new JButton("let's go !");
		b.setBackground(Color.MAGENTA);
		b.setBounds(350, 300, 100, 50);
		b.addActionListener(this);
		img = new ImageIcon(".\\assests\\ggg.jpg");
		label = new JLabel(img);
		label.setBounds(0, 0, 800, 600);
		panel.add(label1);
		panel.add(label2);
		panel.add(field1);
		panel.add(field2);
		panel.add(b);
		panel.add(label);
		this.add(panel);
		this.revalidate();
		this.repaint();
	}

	public static void main(String[] args) {
		new GameFrame();
	}

	public void actionPerformed(ActionEvent e) {
		
	}

	public JLayeredPane getPanel() {
		return panel;
	}

	public JLabel getLabel() {
		return label;
	}

	public ImageIcon getImg() {
		return img;
	}

	public JButton getbutton() {
		return b;
	}

	public JTextField getField1() {
		return field1;
	}

	public JTextField getField2() {
		return field2;
	}

}
