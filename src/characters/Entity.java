package characters;

public class Entity {
	public int X, Y;
	public float Speed = 0f;
	
	// BufferedImage descreve uma imagem com um buffer acessível de dados de imagem
	// nos usamos isso para armazenar os nossos arquivos de imagem
	public String direction; // nome da direção para ser usado no sprite
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
}
