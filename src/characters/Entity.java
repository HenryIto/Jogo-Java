package characters;

import java.awt.image.BufferedImage;

public class Entity {
	public int X, Y;
	public float Speed = 0f;
	
	// BufferedImage descreve uma imagem com um buffer acessível de dados de imagem
	// nos usamos isso para armazenar os nossos arquivos de imagem
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
}
