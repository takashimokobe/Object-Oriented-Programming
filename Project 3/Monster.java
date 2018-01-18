/**
 * Filename: Monster
 *
 * Description: Monster is an abstract class that describes a monster in the maze
 *
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */
import java.util.Random;

public class Monster extends RandomOccupant {

	//Constructors
	public Monster(Maze maze){
		super(maze);
	}

	public Monster(Maze maze, long seed){
		super(maze, seed);
	}

	public Monster(Maze maze, Square location){
		super(maze, location);
	}
}