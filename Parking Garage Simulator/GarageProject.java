/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package garage.project;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author superuser
 */
public class GarageProject {

    public static void main(String[] args) throws Exception {
        
        // variable to store plate numbers as they are read
        String name;
        
        // variable to hold arrive or depart action
        String action;
        
        Scanner read = new Scanner (new File("garage.txt")); 
        
        PrintWriter toFile = new PrintWriter("Output.txt") ;
        
        // Create garage object.
        Garage bashemin = new Garage() ;
        
        // while not end of file
        while (read.hasNext())
        {
         //add blank line between each cars output
         System.out.println("");
         toFile.println("");
        
         name = read.next();
         
         action = read.next();
         
         // test for arrival vs departure
         if(action.equals("ARRIVE"))
         {
             // Create car object
             Car nextCar = new Car(name);
             
             // echo input operations to window and output file
             System.out.println("Car with plate number: "+ name + " is arriving"
                     +  ".");
             
             toFile.println("Car with plate numbers: "+ name + " is arriving"
                     +  ".");
             
             // if garage is not full add car, else turn car away.
             if (bashemin.arrive(nextCar) == true)
             {
                 
                 System.out.println("Car has been parked.");
                 
                 toFile.println("Car has been parked");
             }
             else
             {
                 System.out.println("No room for this car!");
                 
                 toFile.println("No room for this car!");
             }
                 
         }
          // if car fails arrival test, it must be a departure.
         else
         {  
             System.out.println("Car with plate number: "+ name +
                     " is departing.");
             
             toFile.println("Car with plate number: "+ name +
                     " is departing.");
             
            // if depart method finds car in array, get values and remove car..
             //                                          else car not found.
            if ( bashemin.depart(name) == true)
            {
                int moves = bashemin.getLeft().getMoves();
                
                System.out.println("Car has left the garage. Car moved: " 
                        + moves + " times.");
                
                toFile.println("Car has left the garage. Car moved: " 
                        + moves + " times.");
            }
            else
            {
                System.out.println("Car not found in Garage!");
                
                toFile.println("Car not found in Garage!");
               
            }
             
         }
         
        }
        // close output file
        toFile.close();
        
    }
}
