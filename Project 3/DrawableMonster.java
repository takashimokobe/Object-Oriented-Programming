/**
 * Filename: DrawableMonster.java
 *
 * Description: Allows us to create a monster object as well as drawing it. 
 *
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */
public class DrawableMonster extends Monster implements Drawable {

	public DrawableMonster(Maze maze){
		super(maze);
	}

	public DrawableMonster(Maze maze, long seed){
		super(maze, seed);
	}

	public DrawableMonster(Maze maze, Square location){
		super(maze, location);
	}

	public void draw(){

	}
}