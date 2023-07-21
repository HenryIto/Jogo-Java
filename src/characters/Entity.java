package characters;

public abstract class Entity {
	public float MAX_SPEED = 4f; // velocidade máxima que a entidade vai andar; é usado junto com a variável speed
	
	final public String name;
	public int xPos, yPos;
	public float speed = 0f;
	
	public int horizontalDirection = 1; // nome da direção para ser usado no sprite
	public String state = "idle"; // nome do stado do sprite
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Entity(String name, int xPos, int yPos) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
	}
}
