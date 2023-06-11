package characters;

public class Entity {
	public String Name = "<EntityName>";
	public float MAX_SPEED = 4f;
	public int x, y;
	public float speed = 0f;
	
	public int verticalDirection = 1; // nome da direção para ser usado no sprite
	public String state = "idle"; // nome do stado do sprite
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
}
