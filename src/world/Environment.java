package world;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import tiles.TileManager;
import main.GamePanel;

public class Environment extends TileManager {
	GamePanel gp;
	int[][] tileTypeMap;
	
	public Environment(GamePanel gamePanel, String name) {
		super(gamePanel); // chama o constructor da classe TileManager
		this.gp = gamePanel;
		setTileFromCoordinate(name);
	}
	
	public void setTileFromCoordinate(String name) {
		BufferedImage referenceImage = getImage("/world/" + name + ".png");
		width = referenceImage.getWidth();
		height = referenceImage.getHeight();
		
		tileTypeMap = new int[width][height];
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				int pixelColor = referenceImage.getRGB(col, row);

	            // Separa os componentes de cor (RGB) do pixel
	            int red = (pixelColor >> 16) & 0xFF;
	            int green = (pixelColor >> 8) & 0xFF;
	            int blue = pixelColor & 0xFF;
	            
	            int tileType;
	            if (red == 106 && green == 190 && blue == 48) {
	            	tileType = 0; // grass
	            } else if (red == 217 && green == 160 && blue == 102) {
	            	tileType = 1; // dirt
	            } else if (red == 99 && green == 155 && blue == 255) {
	            	tileType = 2; // water
	            } else {
	            	tileType = 0; // grass
	            }
				tileTypeMap[col][row] = tileType;
			}
		}
	}
	
	public BufferedImage getImage(String imagePath) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public void draw(Graphics2D g2d) {
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				int worldX = col * gp.tileSize;
				int worldY = row * gp.tileSize;
				int screenX = worldX - gp.player.xPos + gp.player.xCam;
				int screenY = worldY - gp.player.yPos + gp.player.yCam;
				int tileType = tileTypeMap[col][row];

				// esse if faz com que não carregue o mapa inteiro faz com que carregue o mapa comforme a camera
				if(worldX + gp.tileSize > gp.player.xPos - gp.player.xCam &&
				   worldX - gp.tileSize < gp.player.xPos + gp.player.xCam &&
				   worldY + gp.tileSize> gp.player.yPos - gp.player.yCam &&
				   worldY - gp.tileSize < gp.player.yPos + gp.player.yCam) {
					g2d.drawImage(tile[tileType].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				}
			}
		}
	}
}
