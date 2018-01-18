/**
 * Filename: DrawableExplorer.java
 *
 * Description: A explorer that can be drawn
 *
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */
public class DrawableExplorer extends Explorer implements Drawable{

	public DrawableExplorer(Square location, Maze maze, String name){
		super(location, maze, name);
	}

	public void draw(){
	   pushMatrix();
       fill(0);
       translate( this.location().x()+25  ,  this.location().y()+35 );
       fill(#FFCC99);
       triangle(10, 0, -15, -10, -20, -30);
       triangle(-10, 0, 15, -10, 20, -30);
       triangle(0, -15, 5, 15, 10, 15);
       triangle(0, -15, -5, 15, -10, 15);
       ellipse(0, -10, 25, 25); 
       fill(255);
       ellipse(0, -10, 20, 20);
       fill(0,255,0);
       fill(0);
       ellipse(-3, -12, 3, 3);
       ellipse(3, -12, 3, 3);
       fill(255, 255, 0);
       triangle(-3, -10, 3, -10, 0, -3);
       popMatrix();
	}
}