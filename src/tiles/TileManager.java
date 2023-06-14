package tiles;

import main.GamePanel;

public class TileManager {
	GamePanel gp; // acho que é a interface
	Tile[] tile; // vetor de tiles
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[10];
	}
}
