import java.util.ArrayList;
import java.io.PrintWriter;



/**
 *
 * @author Jamelle Welch
 */
public class Army {
    private ArrayList<Regiment> Army;
    
    public Army()
    {
        Army = new ArrayList<Regiment>();
    }

    
    public void addRegiment(Regiment a)
    {
        Army.add(a);
    }
    
    public void addMen( int newMen)
    {
        int men = newMen;
        for(int i = 0; i < Army.size(); i++)
        {
            if(Army.get(i).getId()==5)
            {
                men = 30;
            }
            Army.get(i).addMen(men);
            
            men = newMen;
        }
        
        
    }
    
    public int getLargest()
    {
        int regiment = 0;
        int min = 0;
        
        for(int i = 0; i < Army.size(); i++)
        {
            
            
            if (Army.get(i).getMen() > min)
            {
                regiment = i;
                min = Army.get(i).getMen();
            } 
        }
        
        return regiment;
    }
    
    public void report()
    {
        int shipOut = getLargest();
        String supplyX = "";
       
        System.out.println(Align.right("Shipping Out!", 20)+ 
                Align.right("Number", 20)+ Align.right("Name", 20)
                + Align.right("Strength", 20));
        
        for(int i=0; i<Army.size(); i++)
        {
            if(i==shipOut)
            {
                supplyX = "x";
            }
        
            System.out.println(Align.right(supplyX, 20)+ 
                Align.right(Army.get(i).getId(), 20)+ 
                Align.right(Army.get(i).getName(), 20)+
                Align.right(Army.get(i).getMen(), 20));
            
            supplyX = "";
        }
        
    }
    
    public void shipOut()
    {
        int shipOut = getLargest();
        Army.remove(shipOut);
    }
           
    
}
