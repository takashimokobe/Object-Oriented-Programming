/**
 * Filename: Treasure
 *
 * Description: Treasure is class that creates a location for a treasure, and lets it be found.
 *
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */
public class Treasure extends RandomOccupant {

	//Instance variables
	private boolean found;

	//Constructors
	public Treasure(Maze maze){
		super(maze);
		found = false;
		location().setTreasure(this);
	}

	public Treasure(Maze maze, long seed){
		super(maze, seed);
		found = false;
		location().setTreasure(this);

	}

	public Treasure(Maze maze, Square location){
		super(maze, location);
		found = false;
		location().setTreasure(this);
	}

	//Methods
	public boolean found(){
		return found;
	}

	public void setFound(){
		found = true;
	}

	@Override public void move(){
		
	}
}