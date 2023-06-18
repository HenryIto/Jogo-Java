package tiles;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp; // acho que é a interface
	Tile[] tile; // vetor de tiles
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[3];
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
}
