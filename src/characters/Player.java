package characters;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	GamePanel gp;
	KeyHandler key;
	
	public final int xCam, yCam;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		this.gp = gamePanel;
		this.key = keyHandler;
		
		xCam = gp.screenWidth/2 - (gp.tileSize/2);
		yCam = gp.screenHeight/2 - (gp.tileSize/2);
		
		setDefaultValues();
	}
	
	public void setDefaultValues() {
		name = "Remy";
//		worldX = gp.tileSize * 23;
//		worldY = gp.tileSize * 21;
		xPos = 100;
		yPos = 100;
	}
	
	public void update() {
		boolean verticalMovement = key.upPressed || key.downPressed;
		boolean horizontalMovement = key.leftPressed || key.rightPressed;
		
		speed = MAX_SPEED; // define a velocidade do Player
		
		float spriteDelaySeconds = .1f;
		float spriteTransitionDelay = (60 * spriteDelaySeconds); // transforma segundos em frames por segundo
		spriteCounter++;
		if (spriteCounter > spriteTransitionDelay) {
			int spriteFirstFrame = 1;
			int spriteLastFrame = 6;
			spriteNum = (spriteNum >= spriteLastFrame) ? spriteFirstFrame : spriteNum + 1;
			spriteCounter = 0;
		}
		
		if (!verticalMovement && !horizontalMovement) {
			spriteNum = 1; // reseta o frame pra ficar sempre no primeiro
			state = "idle"; // sprite parado
		} else {
			state = "run"; // sprite correndo
		}
		
		
		if (verticalMovement && horizontalMovement) {
			speed = MAX_SPEED * .75f; // caso ele esteja andando na diagonal vai diminuir a velocidade total do Player
		}
		
		if (verticalMovement) {
			int verticalDirection = key.downPressed ? 1 : -1; // isso vai fazer o Player ir para cima ou para baixo dependendo de qual tecla estiver apertada
			yPos += speed * verticalDirection; // isso vai fazer o Player se mover na _vertical_
		}
		if (horizontalMovement) {
			verticalDirection = key.rightPressed ? 1 : -1; // isso vai fazer o Player ir para esquerda ou para direita dependendo de qual tecla estiver apertada
			xPos += speed * verticalDirection; // isso vai fazer o Player se mover na _horizontal_
		}
		// System.out.println(Speed);
	}
	
	// este é o sprite do player
	public void draw(Graphics2D g2) {
		// BufferedImage descreve uma imagem com um buffer acessível de dados de imagem
		// nos usamos isso para armazenar os nossos arquivos de imagem
		BufferedImage image = null;
		
		try {
			String spriteName = "/player/player_" + state + "_" + spriteNum + ".png"; // seleciona o nome do sprite do player de acordo com as variaveis
			image = ImageIO.read(getClass().getResourceAsStream(spriteName)); // pega o sprite de acordo com o nome do sprite
		} catch(Exception error) {
			error.printStackTrace(); // caso dê errado ele manda um erro, eu acho...
		}
		
		int xOffset = (gp.tileSize/2 * verticalDirection) - gp.tileSize/2; // faz com que a image não fique descentralizada quando o personagem muda a direção
		int width = gp.tileSize * verticalDirection; // largura do sprite
		int height = gp.tileSize; // altura do sprite
		// desenha a imagem na tela
		g2.drawImage(image, xCam - xOffset, yCam, width, height, null);
	}
}
