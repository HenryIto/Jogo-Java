package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	
	//screen settings
	final int originalTileSize = 16; // 16x16 blocos
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale; // 48x48 blocos
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 567 pixels
	
	// thread é algo que você pode iniciar e parar
	// e uma vez que uma thread é iniciada, ele mantém seu programa rodando
	// até você parar
	Thread gameThread;
	// para se usar threads você precisar implementar Runnable na class
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		// faz com que o jogo renderize melhor jogo
		this.setDoubleBuffered(true);
	}
	
	public void startGameThread() {
		// esse this significa que estamos passando essa class GamePanel
		// para o construtor desta thread e é dessa for que se instancia uma thread
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	// quando iniciamos este gameThread ele chama automaticamente esse metodo run
	@Override
	public void run() {
		// enquanto este gameThread existir ele vai ficar executando o que ta dentro do while
		while(gameThread != null) {
			// update ele atualiza a posição do personagem
			update();
			
			// em vez de escrever paintComponent para chamar a função
			// voce escreve repaint
			repaint();
			//teste
		}
	}
	public void update() {
		
	}
	// esse metodo paintComponent é um metodo embutido do Java
	// graphics é uma class que tem varias funções para desenhar na tela
	public void paintComponent(Graphics g) {
		// esse super significa classe pai desta classe
		// e neste caso a classe pai é a JPanel porque o GamePanel é uma subclass da JPanel
		super.paintComponent(g);
	}

    // AGORA ESSE CÓDIGO É MEU
}
