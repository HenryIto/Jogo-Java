package tiles;

import java.awt.Graphics2D;
import java.io.IOException;

import main.GamePanel;

public class TileManager {
	GamePanel gamePanel; // acho que é a interface
	public Tile[] tile; // vetor de tiles
//	int mapTileNum[] [];
	
	public int width;
	public int height;
	
	public TileManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		tile = new Tile[3];
//		mapTileNum = new int [gamePanel.maxWorldCol][gamePanel.maxWorldRow];
		this.width = gamePanel.screenWidth / gamePanel.tileSize;
		this.height = gamePanel.screenHeight / gamePanel.tileSize;
		
		getTileImage();
	}
	
	public void setTileType() {
		
	}
	
	public void getTileImage() {
		try {
			String[] tilesNames = { "grass", "dirt", "water" };
			for (int i = 0; i < tilesNames.length; i++) {
				tile[i] = new Tile(tilesNames[i]);
			}
			tile[2].collision = true; // water collision
		} catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2d) {
		System.out.println(width + height);
		for (int worldRow = 0; worldRow < height; worldRow++) {
			for (int worldCol = 0; worldCol < width; worldCol++) {
				g2d.drawImage(tile[0].image, worldCol * gamePanel.tileSize, worldRow * gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
			}
		}
	}
}
