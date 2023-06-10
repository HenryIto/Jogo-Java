package characters;

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
	
	GamePanel gp;
	KeyHandler key;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		this.gp = gamePanel;
		this.key = keyHandler;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		X = 100;
		Y = 100;
		Speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			
			// ImageIO.read carrega uma imagem que esta dentro do arquivo
			// getClass().getResourceAsStream("/Player/boy_up_1.png") retorna um objeto 'InputStream' que representa o fluxo de bytes da imagem 'boy_up_1.png'
			// getClass() retorna o objeto Class para a classe em que esse código está sendo executado
			// getResourceAsStream() é um método dessa classe que permite obter um fluxo de bytes para um recurso no mesmo diretório ou pacote da classe.
			// ImageIO.read() lê o fluxo de bytes da imagem e retorna um objeto BufferedImage que representa a imagem carregada. 
			// Portanto, essa linha de código carrega a imagem "boy_up_1.png" e retorna um objeto BufferedImage contendo essa imagem.
			up1 = ImageIO.read(getClass().getResourceAsStream("../assets/sprites/Player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("../assets/sprites/Player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("../assets/sprites/Player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("../assets/sprites/Player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("../assets/sprites/Player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("../assets/sprites/Player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("../assets/sprites/Player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("../assets/sprites/Player/boy_right_2.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Update() {
		boolean verticalMovement = key.upPressed || key.downPressed;
		boolean horizontalMovement = key.leftPressed || key.rightPressed;
		
		Speed = MAX_SPEED; // define a velocidade do Player
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
//		g2.setColor(Color.white);
//		// desenha um quadrado e preeche com a cor branca (int x, int y, int widht, int height)
//		g2.fillRect(X, Y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			image = up1;
		break;
		case "down":
			image = down1;
		break;
		case "left":
			image = left1;
		break;
		case "right":
			image = right1;
		break;
		}
		
		// desenha a imagem na tela
		g2.drawImage(image, X, Y, gp.tileSize, gp.tileSize, null);
	}
}
