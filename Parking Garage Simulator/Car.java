/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package garage.project;

/**
 * @author superuser
 */

/**
 *  Class to represent a car that contains the plate number and the number of
 * times the car was moved.
 * @param name the license plate number.
 * @param moves the number of times the car was moved because of departures.
 */
public class Car {
    
  private String name;  // license plate number
  private int moves = 0;    // number of moves car has endured
  
  /**
   * Assigns plate number to the name variable.
   * @param number the plate number.
   */
  public Car(String number)
  {
      name = number;
  }
  
  /**
   * increments number of moves for a car.
   */
  public void addMove()   //increment number of moves
  {
      moves = moves + 1;
  }
  
  /**
   * Gets the plate number of car.
   * @return the plate number.
   */
  public String getName()
  {
      return name;
  }
   
  /**
   * Gets the number of times the car was moved.
   * @return the number of moves.
   */
  public int getMoves()
  {
      return moves;
  }
   
   
   
    
}
