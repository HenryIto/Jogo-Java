package tiles;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp; // acho que é a interface
	Tile[] tile; // vetor de tiles
	public int elementNum;
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		this.elementNum = (int) (Math.random() * 3);
		tile = new Tile[3];
		
		getTileImage();
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
		
		
		int width = gp.getWidth() / gp.tileSize;
		int height = gp.getHeight()	/ gp.tileSize;
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				g2d.drawImage(tile[elementNum].image, col * gp.tileSize, row * gp.tileSize, gp.tileSize, gp.tileSize, null);
			}
		}
	}
}
