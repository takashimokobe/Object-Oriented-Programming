/**
 * Filename: Occupant
 *
 * Description: Occupant is an abstract class that describes an occupant in the Maze
 *
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */

import java.awt.*;
import java.util.*;

public abstract class Occupant{

	//instance variables
	private Square location;
	private Maze maze;

	//Constructors
	public Occupant (Maze maze){
		this.maze = maze;
	}

	public Occupant (Maze maze, Square start){
		this.maze = maze;
		this.location = start;
	}

	//Methods
	public Square location(){
		return location;
	}

	public Maze maze(){
		return maze;
	}

	public void moveTo(Square newLoc){
		location = newLoc;
	}
}