/* This is the CartesianPoint class that defines a point in Cartesian coordinates
* Takahiro Shimokobe 
* Project 1  
* CPE102-01 */ 

import java.lang.Math;

public class CartesianPoint implements Point{
	private double xCoordinate;
	private double yCoordinate;
	private double angle;
	private double radius;

	//Constructor 
	public CartesianPoint(double xCoordinate, double yCoordinate){
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	//Methods
	public double angle(){ //returns an angle based on the x and y coordinates given
		return Math.atan2(yCoordinate, xCoordinate);
	}

	public double radius(){ //returns the radius of the line segment between the two points
		return Math.sqrt(Math.pow(xCoordinate(), 2) + Math.pow(yCoordinate(), 2));
	}

	public Point rotate90(){ // rotates the x and y coordinates by 90 degrees
		return new CartesianPoint(-yCoordinate, xCoordinate);
	}

	public double xCoordinate(){ //returns some x coordinate for a point
		return xCoordinate;
	}

	public double yCoordinate(){ //retruns some y coordinate for a point
		return yCoordinate;
	}
	
	public double distanceFrom(Point other){ //computes the distance between two points
		double x = xCoordinate() - other.xCoordinate();
		double y = yCoordinate() - other.yCoordinate();
		return Math.sqrt(x*x + y*y);
	}
}