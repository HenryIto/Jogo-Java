package tiles;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

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
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
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
