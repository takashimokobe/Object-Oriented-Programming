import java.util.*;
/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Takahiro Shimokobe
 *
 *
 */

public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] squares, int rows, int cols)
   {
    this.squares = squares;
    this.rows = rows;
    this.cols = cols;
		this.randOccupants = new ArrayList<RandomOccupant>();
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   // CHANGE - Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   //          Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) {
    return randOccupants.get(index);
   }
   public int getNumRandOccupants() {
    return randOccupants.size();
   }
	
   // COMMANDS
   // CHANGE - implement the following method
   public void addRandomOccupant(RandomOccupant ro) { 
     randOccupants.add(ro);
  }
	
   public void setExplorer(Explorer e) {explorer = e;}
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
    for (int i = 0; i < randOccupants.size(); i++){
      randOccupants.get(i).move();
    }
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
        
      // CHANGE - implement
      if (foundAllTreasures()){
        return EXPLORER_WIN;
      }
      for (int i = 0; i < randOccupants.size(); i++){
        if (randOccupants.get(i) instanceof Monster){
          if (getExplorer().location() == randOccupants.get(i).location()){
            return MONSTER_WIN;
          }
        }
      }
      return status;
  }

   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      for (int i = 0; i < getNumRandOccupants(); i ++){
        if (getRandomOccupant(i) instanceof Treasure){
          if (!getRandomOccupant(i).location().treasure().found()){
            return false;
          }
        }
      }
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
        
      resetInView();
        
      s.setInView(true);
        
      
     if (!s.wall(Square.UP)){

         getSquare(s.row() - 1, s.col()).setInView(true); //UP

         if (!getSquare(s.row() - 1, s.col()).wall(Square.RIGHT)){
            getSquare(s.row() - 1, s.col() + 1).setInView(true);  
         }
         if (!getSquare(s.row() - 1, s.col()).wall(Square.LEFT)){
            getSquare(s.row() - 1, s.col() - 1).setInView(true);
         }
      }

      if (!s.wall(Square.DOWN)){
         getSquare(s.row() + 1, s.col()).setInView(true);

         if (!getSquare(s.row() + 1, s.col()).wall(Square.RIGHT)){
            getSquare(s.row() + 1, s.col() + 1).setInView(true);
         }
         if (!getSquare(s.row() + 1, s.col()).wall(Square.LEFT)){
            getSquare(s.row() + 1, s.col() - 1).setInView(true);
         }
      }

      if (!s.wall(Square.RIGHT)){
         getSquare(s.row(), s.col() + 1).setInView(true);

         if (!getSquare(s.row(), s.col() + 1).wall(Square.UP)){
            getSquare(s.row() - 1, s.col() + 1).setInView(true);
         }
         if (!getSquare(s.row(), s.col() + 1).wall(Square.DOWN)){
            getSquare(s.row() + 1, s.col() + 1).setInView(true);
         }
      }

      if (!s.wall(Square.LEFT)){
         getSquare(s.row(), s.col() - 1).setInView(true);

         if (!getSquare(s.row(), s.col() - 1).wall(Square.UP)){
            getSquare(s.row() - 1, s.col() - 1).setInView(true);
         }
         if (!getSquare(s.row(), s.col() - 1).wall(Square.DOWN)){
            getSquare(s.row() + 1, s.col() - 1).setInView(true);
         }
      }
   }
    
   private void resetInView()
   {
      for (int i = 0; i < rows; i++) {
         for (int k = 0; k < cols; k++) {
            squares[i][k].setInView(false);
         }
      }
   }
}
