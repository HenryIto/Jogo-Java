package characters;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	// constantes: 'final' define que a variavel é uma constante, ou seja, ela não pode ser alterada.
	public final String Name = "Remy";
	public final float MAX_SPEED = 4f;
	
	GamePanel gp;
	KeyHandler key;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		this.gp = gamePanel;
		this.key = keyHandler;
	}
	
	public void Update() {
		boolean verticalMovement = key.upPressed || key.downPressed;
		boolean horizontalMovement = key.leftPressed || key.rightPressed;
		
		int velocity = 4;
		Speed = MAX_SPEED; // define a velocidade do Player
		if (verticalMovement && horizontalMovement) {
			Speed = velocity * .75f; // caso ele esteja andando na diagonal vai diminuir a velocidade total do Player
		}
		
		if (verticalMovement) {
			int verticalDirection = key.downPressed ? 1 : -1; // isso vai fazer o Player ir para cima ou para baixo dependendo de qual tecla estiver apertada
			Y += Speed * verticalDirection; // isso vai fazer o Player se mover na _vertical_
		}
		if (horizontalMovement) {
			int horizontalDirection = key.rightPressed ? 1 : -1; // isso vai fazer o Player ir para esquerda ou para direita dependendo de qual tecla estiver apertada
			X += Speed * horizontalDirection; // isso vai fazer o Player se mover na _horizontal_
		}
		
		// System.out.println(Speed);
	}
	
	// este é o sprite do player
	public void Draw(Graphics2D g2) {
		g2.setColor(Color.white);
		// desenha um quadrado e preeche com a cor branca (int x, int y, int widht, int height)
		g2.fillRect(X, Y, gp.tileSize, gp.tileSize);
	}
}
