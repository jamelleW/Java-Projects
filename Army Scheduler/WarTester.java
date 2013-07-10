import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Jamelle Welch
 */
public class WarTester {
    
    public static void main(String[] args) throws IOException
    {
        int men = 1000;
        
        Army javaArmy = new Army();
        
        Scanner textScan = new Scanner(new File("C:\\Users\\superuser\\Downloads\\"
                + "regiments.txt"));
        
        
        while(textScan.hasNext())
                {
                    int number = textScan.nextInt();
                    String name = textScan.next();
                    int i = 1;
                    
                    Regiment newRecruits = new Regiment(number, name, men);
                    
                    javaArmy.addRegiment(newRecruits);
                    
                    men=men-50;
                    
                }
        
       for(int i = 1; i <= 20; i++)
       {
          
           int newMen=100;
           int newMen30=30;
           
           javaArmy.addMen(100);
           
           System.out.println("WEEK"+i);
           
           javaArmy.report();
           
           javaArmy.shipOut();
           
                   
       }
        
        
        
        
        
        
        
        
    }
    
}
