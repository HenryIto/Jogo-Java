package characters;

public class Entity {
	public float MAX_SPEED = 4f; // velocidade máxima que a entidade vai andar; é usado junto com a variável speed
	
	public String name = "EntityName";
	public int xPos, yPos;
	public float speed = 0f;
	
	public int verticalDirection = 1; // nome da direção para ser usado no sprite
	public String state = "idle"; // nome do stado do sprite
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
}
