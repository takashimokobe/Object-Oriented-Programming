/**
 * Filename: Explorer
 *
 * Description: Explorer is a class that extends Occupant that represents the Player controlled character that moves around in the maze based on keyboard input.
 *
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */

import java.awt.event.KeyEvent;

public class Explorer extends Occupant {

	//instance variables
	private String name;

	//Constructors
	public Explorer(Square location, Maze maze, String name){
		super(maze, location);
		this.name = name;

		maze.lookAround(location);
	}

	//Methods
	public String name(){
		return name;
	}

	public void move (int key){
		int row = location().row();
		int col = location().col();

		int direction = 0;

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP){
			direction = Square.UP;
			if (!location().wall(direction)){
				moveTo(maze().getSquare(row - 1, col));
			}
			}
		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN){
			direction = Square.DOWN;
			if (!location().wall(direction)){
				moveTo(maze().getSquare(row + 1, col));
			}
		}
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_KP_RIGHT){
			direction = Square.RIGHT;
			if (!location().wall(direction)){
				moveTo(maze().getSquare(row, col + 1));
			}
		}
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_KP_LEFT){
			direction = Square.LEFT;
			if (!location().wall(direction)){
				moveTo(maze().getSquare(row, col -1));
			}
		}
	}

	public void moveTo(Square s){ //Command the Explorer to move to another Square in the Maze.
		super.moveTo(s);
		s.enter();
		maze().lookAround(s);
	}
}