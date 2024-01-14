package views;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class VideoClass extends JFrame{
	JButton b;
	JLayeredPane panel0;
	JLabel label0;
	ImageIcon img;
	Clip clip1;
	public VideoClass() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		this.setBounds(120,40,1290,750);
		this.setVisible(true);
		this.setTitle("Marvel Ultimate War");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		panel0 = new JLayeredPane();
		File base = new File("marvid.wav");
		clip1 = AudioSystem.getClip();
		clip1.open(AudioSystem.getAudioInputStream(base));
		clip1.start();
		b = new JButton("Skip");
		b.setBackground(Color.BLACK);
		b.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
		b.setBounds(1050, 550, 110, 60);
		b.setForeground(Color.RED);
		img = new ImageIcon(".\\assests\\marvid.gif");
		label0 = new JLabel(img);
		label0.setBounds(0, 0,1280,720);
		panel0.add(b);
		panel0.add(label0);
		this.add(panel0);
		this.revalidate();
		this.repaint();
	}
	public Clip getClip1() {
		return clip1;
	}
	public JButton getB() {
		return b;
	}
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		new VideoClass();
	}
 
 
}
