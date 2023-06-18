package world;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import tiles.TileManager;
import main.GamePanel;

public class Environment extends TileManager {
	GamePanel gp;
	int[][] tileFromCoordinate;
	
	public Environment(GamePanel gp, String name) {
		super(gp);
		setTileFromCoordinate(name);
	}
	
	public void setTileFromCoordinate(String name) {
		final BufferedImage referenceImage = getImage("/world/" + name + ".png");
		this.width = referenceImage.getWidth();
		this.height = referenceImage.getHeight();
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				tileFromCoordinate[row][col] = 0;
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
				g2d.drawImage(tile[0].image, col * gp.tileSize, row * gp.tileSize, gp.tileSize, gp.tileSize, null);
			}
		}
	}
}
