/* This is the PolarPoint class that defines a point in polar coordinates
* Takahiro Shimokobe 
* Project 1  
* CPE102-01 */ 

public class PolarPoint implements Point {
	private double xCoordinate;
	private double yCoordinate;
	private double radius;
	private double angle; 

	//Constructor 
	public PolarPoint(double radius, double angle){
		this.radius = radius;
		this.angle = angle;
	}

	//Methods
	public double angle(){ //returns some angle value
		return angle;
	}

	public double radius(){
		return radius;
	}

	public double distanceFrom(Point other){
		return Math.sqrt(radius()*radius() + other.radius()*other.radius() - 2*radius()*other.radius()*Math.cos(other.angle() - angle()));
	}


	public Point rotate90(){
		return new PolarPoint(radius, angle() + Math.PI/2);
	}

	public double xCoordinate(){
		return radius * Math.cos(angle);
	}

	//Returns some y coordinate for a point
	public double yCoordinate(){
		return radius * Math.sin(angle);
	}
}