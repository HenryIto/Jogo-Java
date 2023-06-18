package world;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import tiles.Tile;
import main.GamePanel;

public class Environment {
	GamePanel gp;
	
	public Environment(GamePanel gp, String name) {
		this.gp = gp;
		
		final BufferedImage referenceImage = getImage(name);
		int width = referenceImage.getWidth();
		int height = referenceImage.getHeight();
	}
	
	public BufferedImage getImage(String name) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/world/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public void draw(Graphics2D g2d) {	
//		int pixelColor = referenceImage.getRGB(col, row);
//		
//		// Separa os componentes de cor (RGB) do pixel
//        int red = (pixelColor >> 16) & 0xFF;
//        int green = (pixelColor >> 8) & 0xFF;
//        int blue = pixelColor & 0xFF;
//		
//		Tile tile = new Tile(gp, red, green, blue);
//		int x = row * gp.tileSize;
//		int y = col * gp.tileSize;
//		tile.draw(g2d, x, y);
	}
}
