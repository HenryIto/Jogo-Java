package characters;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	// constantes: 'final' define que a variavel é uma constante, ou seja, ela não pode ser alterada.
	public final String Name = "Remy";
	public final float MAX_SPEED = 4f;
	
	// teste
	GamePanel gp;
	KeyHandler key;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		this.gp = gamePanel;
		this.key = keyHandler;
		
		setDefaultValues();
	}
	
	public void setDefaultValues() {
		X = 100;
		Y = 100;
		Speed = 4;
		direction = "down";
	}
	
	public void Update() {
		boolean verticalMovement = key.upPressed || key.downPressed;
		boolean horizontalMovement = key.leftPressed || key.rightPressed;
		
		Speed = MAX_SPEED; // define a velocidade do Player
		
		if(verticalMovement || horizontalMovement) {
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2; 
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}else {
			spriteNum = 1; 
		}
		if (verticalMovement && horizontalMovement) {
			Speed = MAX_SPEED * .75f; // caso ele esteja andando na diagonal vai diminuir a velocidade total do Player
		}
		
		if (verticalMovement) {
			String verticalImageDirection = key.downPressed ? "down" : "up";
			direction = verticalImageDirection;
			int verticalDirection = key.downPressed ? 1 : -1; // isso vai fazer o Player ir para cima ou para baixo dependendo de qual tecla estiver apertada
			Y += Speed * verticalDirection; // isso vai fazer o Player se mover na _vertical_
		}
		if (horizontalMovement) {
			String horizontalImageDirection = key.rightPressed ? "right" : "left";
			direction = horizontalImageDirection;
			int horizontalDirection = key.rightPressed ? 1 : -1; // isso vai fazer o Player ir para esquerda ou para direita dependendo de qual tecla estiver apertada
			X += Speed * horizontalDirection; // isso vai fazer o Player se mover na _horizontal_
		}
		// System.out.println(Speed);
	}
	
	// este é o sprite do player
	public void Draw(Graphics2D g2) {
		BufferedImage image = null;
		try {
			String spriteName = "/Player/player_" + direction + "_" + spriteNum + ".png"; // seleciona o nome do sprite do player de acordo com as variaveis
			image = ImageIO.read(getClass().getResourceAsStream(spriteName)); // pega o sprite de acordo com o nome do sprite
		} catch(Exception error) {
			error.printStackTrace(); // caso dê errado ele manda um erro, eu acho...
		}
		
		// desenha a imagem na tela
		g2.drawImage(image, X, Y, gp.tileSize, gp.tileSize, null);
	}
}
