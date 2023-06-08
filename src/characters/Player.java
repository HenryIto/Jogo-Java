package characters;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	// constantes: 'final' define que a variavel é uma constante, ou seja, ela não pode ser alterada.
	final String Name = "Remy";
	final float MAX_SPEED = 4f;
	
	GamePanel gp;
	KeyHandler k;
	
	public Player(GamePanel gamePanel, KeyHandler keyHandler) {
		this.gp = gamePanel;
		this.k = keyHandler;
	}
}
