/**
 * Filename: RandomOccupant.java
 *
 * Description: Random Occupant is an Occupant that is generated randomly in the maze. 
 *
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */

import java.util.Random;

public abstract class RandomOccupant extends Occupant {

	//Instance variables
	private Random rand = new Random();
	
	//Constructors 
	public RandomOccupant(Maze maze){
		super(maze);
		int row = rand.nextInt(maze.rows());
		int col = rand.nextInt(maze.cols());

		Square square = maze.getSquare(row, col);

		super.moveTo(square);
	}

	public RandomOccupant(Maze maze, long seed){
		super(maze);
		rand = new Random(seed);

		if(maze.rows() > 0){
			if (maze.cols() > 0) {
				int row = rand.nextInt(maze.rows());
				int col = rand.nextInt(maze.cols());

				moveTo(maze.getSquare(row, col));
			}
		}
	}

	public RandomOccupant(Maze maze, Square location){
		super(maze, location);
	}

	//Methods
	public void move(){
		int row = location().row();
		int col = location().col();

		int direction= rand.nextInt(4);

		while (location().wall(direction)){
			direction = rand.nextInt(4);
		}
		if (direction == Square.UP){
			moveTo(maze().getSquare(row - 1, col));
		}
		if (direction == Square.LEFT){
			moveTo(maze().getSquare(row, col - 1));
		}
		if (direction == Square.DOWN){
			moveTo(maze().getSquare(row + 1, col));
		}
		if (direction == Square.RIGHT){
			moveTo(maze().getSquare(row, col + 1));
		}
	}
}
