package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{
	//screen settings
	final int originalTileSize = 16; // 16x16 blocos
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale; // 48x48 blocos
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 567 pixels
	
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	
	// thread é algo que você pode iniciar e parar
	// e uma vez que uma thread é iniciada, ele mantém seu programa rodando
	// até você parar
	Thread gameThread;
	// para se usar threads você precisar implementar Runnable na class
	
	
	// define a posição padrao do player
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		// faz com que o jogo renderize melhor jogo
		this.setDoubleBuffered(true);
		// GamePanel reconhece a entrada da tecla
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		// esse this significa que estamos passando essa class GamePanel
		// para o construtor desta thread e é dessa for que se instancia uma thread
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		
		// é 1 segundo mas convertido em 1 bilhão de nanosegundos para ficar mais precisso
		// 0.016666 por segundo
		double drawInterval = 1000000000/FPS;
		double delta =  0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		// enquanto este gameThread existir ele vai ficar executando o que ta dentro do while
		while(gameThread !=  null) {
			
			currentTime = System.nanoTime();
			
			// (currentTime - lastTime) significa quanto tempo sobrou e divide pelo intervalo que seria 0.016666 segundos
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			// para cada loop adicionamos o tempo passado dividido por drawInterval(0.016666) que armazena no delta
			// e quando este delta atingir este drawInterval então atualiza e repinta e tambem redefine este delta
			if(delta >= 1) {
				// update ele atualiza a posição do personagem
				update();
				
				// repaint desenha a tela com a informação atualizada
				// em vez de escrever paintComponent para chamar a função
				// voce escreve repaint
				repaint();	
				delta--;
				drawCount++;
			}
			
			// quando o timer atingir 1 segundo
			if(timer >= 1000000000) {
				System.out.println("FPS: " +  drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	public void update() {
		boolean verticalMovement = keyH.upPressed || keyH.downPressed;
		boolean horizontalMovement = keyH.leftPressed || keyH.rightPressed;
		
		if (verticalMovement) {
			int verticalDirection = keyH.downPressed ? 1 : -1;
			playerY += playerSpeed * verticalDirection;
		}
		if (horizontalMovement) {
			int horizontalDirection = keyH.rightPressed ? 1 : -1;
			playerX += playerSpeed * horizontalDirection;
		}
	}
	// esse metodo paintComponent é um metodo embutido do Java
	// graphics é uma class que tem varias funções para desenhar na tela
	public void paintComponent(Graphics g) {
		// esse super significa classe pai desta classe
		// e neste caso a classe pai é a JPanel porque o GamePanel é uma subclass da JPanel
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		// desenha um quadrado e preeche com a cor branca (int x, int y, int widht, int height)
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		
		g2.dispose();
	}

}
