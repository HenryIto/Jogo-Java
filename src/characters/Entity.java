package characters;

public class Entity {
	public int x, y;
	public float speed = 0f;
	
	// BufferedImage descreve uma imagem com um buffer acessível de dados de imagem
	// nos usamos isso para armazenar os nossos arquivos de imagem
	public int verticalDirection = 1; // nome da direção para ser usado no sprite
	public String state = "idle";
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
}
