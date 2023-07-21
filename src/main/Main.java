package main;

import java.time.LocalDate;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Shadows of Eternity");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
		
		LocalDate date = LocalDate.of(2001, 12, 21);
		System.out.println(date);
	}

}
