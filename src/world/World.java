package world;

public class World {
	public final int MIN_YEAR = 0;
	public final int MAX_YEAR = 1000;
	public int year;
	
	public World(int year) {
		year = Math.min(year, MAX_YEAR);
		year = Math.max(year, MIN_YEAR);
		this.year = year;
	}
	
	public void teste() {
	}
}
