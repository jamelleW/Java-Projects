/**
 *
 * @author superuser
 */
package garage.project;

import java.util.ArrayList;


/**
 * Class that contains an array list full of car objects. Contains methods to
 * handle departure and arrival operations of the cars.
 * @param justLeft saves the value of a car that just left.
 */
public class Garage {
   
    private Car justLeft;
   
    private ArrayList<Car> Garage;
    
    /**
     * Constructor to intialize empty array list.
     */
    public Garage()
    {
        Garage = new ArrayList<>() ;
    }
    
    /**
     * Adds car to the array if there is room and turns car away if not.
     * @param number the plate numbers for the car
     * @return true if car object is added to array and false if list is full.
     */
    public boolean arrive(Car number)   // Add a car to list if list < 10
    {                                   
        if (Garage.size() < 10)
        {
            Garage.add(number);
            return true;
        }
        
        return false;
            
    }
    
    /** Check for car in garage and remove it. Pass true if car was removed. 
     * Removed car object is assigned to the variable justLeft.
     * @param name the plate number of the car.
     * @return true if car is found in list but false if not.
     */
    public boolean depart(String name) 
    {
       int position = -1;
       
      // Traverse array to check for car position.
       for (int i = 0; i < Garage.size(); i++)  
       {
           String matchName = Garage.get(i).getName();  //get plate number
           if ( name.equals(matchName) )                //compare plate numbers
           {
              position = i;                       // Get index if car is found
           }
       }
       
       // if car is in garage then increment moves for cars ahead of it. 
       // Remove car and add its values to justLeft variable.
       if (position != -1)
       {
           for (int i=position - 1; i >= 0; i--)
           {
               Garage.get(i).addMove();
           }
           
          justLeft = Garage.remove(position);
          
          return true;
              
       }
       
       return false;
    }
    
    /**
     * Gets the value of the variable justLeft.
     * @return justLeft the variable that contains the last car to leave.
     */
    public Car getLeft()
    {
        return justLeft;
    }
    
    
    
    
}
