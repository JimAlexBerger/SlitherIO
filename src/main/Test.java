package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import snake.Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Test extends JFrame {
	Snake snake = new Snake();

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Test() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
					snake.moveMouse(360/4*0);
				}
				if (event.getKeyCode() == KeyEvent.VK_UP) {
					snake.moveMouse(360/4*1);
				}
				if (event.getKeyCode() == KeyEvent.VK_LEFT) {
					snake.moveMouse(360/4*2);
			    }
			    if (event.getKeyCode() == KeyEvent.VK_DOWN) {
					snake.moveMouse(360/4*3);
			    }
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 10, 10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
