 /**
 * Filename: Square
 *
 * Description: Square is a class that represents a Square in the Maze. 
 *
 * @author Takahiro Shimokobe
 * 
 *
 * 
 */

 import java.util.*;
import java.awt.*;

public class Square {

	//Named Constants:
	public static final int SQUARE_SIZE = 50;
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;

	//Instance variables:	
	private boolean[] walls = new boolean[4];
	private boolean seen;
	private boolean inView;
	private int row;
	private int col;
	private Treasure treasure;

	// Constructor:
	public Square (boolean up, boolean right, boolean down, boolean left, int row, int col){
		this.walls[UP] = up;
		this.walls [RIGHT] = right;
		this.walls [DOWN] = down;
		this.walls [LEFT] = left;
		this.row = row;
		this.col = col;
		this.seen = false;
		this.inView = false;
		this.treasure = null;
	}

	// Methods:
	public boolean wall(int direction){
		return walls[direction];
	}

	public boolean seen(){
		return seen;
	}

	public boolean inView(){
		return inView;
	}

	public int row(){
		return row;
	}

	public int col(){
		return col;
	}

	public Treasure treasure(){
		return treasure;
	}

	public int x(){
		int x = col * SQUARE_SIZE;
		return x;
	}


	public int y(){
		int y = row * SQUARE_SIZE;
		return y;
	}

	public void setInView(boolean inView){ //A command to tell the Square if it is currently in view of the Explorer
		if (inView != false){
			seen = true;
		}
		this.inView = inView;
	}

	public void setTreasure(Treasure t){
		treasure = t;
	}

	public void enter(){
		if (treasure != null){
			setTreasure(treasure);
			treasure.setFound();
		}
	}
}