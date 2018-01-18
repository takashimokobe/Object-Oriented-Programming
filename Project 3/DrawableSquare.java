/**
 * Filename: DrawableSquare.java
 *
 * Description: Allows us to create and draw a square in the maze. 
 *
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */
public class DrawableSquare extends Square implements Drawable {
	
	public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col){
		super(up, right, down, left, row, col);
		}

	public void draw(){

	}
}