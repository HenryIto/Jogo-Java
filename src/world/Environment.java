package world;

import java.awt.Graphics2D;
import main.GamePanel;

import tiles.Tile;

public class Environment {
	GamePanel gp;
	
	public String name;
	
	public void drawOnce(Graphics2D g2d) {
		int windowHeight = gp.getHeight() / gp.tileSize; // tamanho do cenário em blocos/unidades
		int windowWidth = gp.getWidth() / gp.tileSize;
		
		/**
		 * row = linhas (rows)
		 * col = colunas (columns)
		 */
		for (int row = 0; row < windowHeight; row++) {
			for (int col = 0; col < windowWidth; col++) {
				
			}
		}
	}
}
