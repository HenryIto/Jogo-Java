package main;

import characters.Entity;

public class CollisionChecker {
	GamePanel gamePanel;
	public CollisionChecker(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void checkTile(Entity entity) {
		int entityLeft = entity.xPos + entity.solidArea.x;
		int entityRight = entity.xPos + entity.solidArea.x + entity.solidArea.width;
		int entityTop = entity.yPos + entity.solidArea.y;
		int entityBottom = entity.yPos + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeft / gamePanel.tileSize;
		int entityRightCol = entityRight / gamePanel.tileSize;
		int entityTopCol = entityTop / gamePanel.tileSize;
		int entityBottomCol = entityBottom / gamePanel.tileSize;
		
		int tileNum1, tileNum2;
		
		/**
		 * a partir daqui fudeu...
		 * calma aí que uma hora eu arrumo. 
		 */
		switch (entity.horizontalDirection) {
		default:
			break;
		}
	}
}
