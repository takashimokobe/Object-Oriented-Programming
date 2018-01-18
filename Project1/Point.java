/* This is the Point interface
* Takahiro Shimokobe
* Project 1
* CPE 102 -01*/

public interface Point {
	double xCoordinate();
	double yCoordinate();
	double radius();
	double distanceFrom(Point other);
	Point rotate90();
}