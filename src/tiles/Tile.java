package tiles;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
	public String name;
	public BufferedImage image;
	public boolean collision = false;
	
	public Tile(String name) throws IOException {
		this.name = name;
		image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + name + ".png"));
	}
}
