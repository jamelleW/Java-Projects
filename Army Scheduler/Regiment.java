

/**
 *
 * @author Jamelle Welch
 */
public class Regiment
{
   private int id ;
   private String name;
   private int men;
    
    public Regiment(int id, String name, int men)
    {
        this.id = id;
        this.name = name;
        this.men = men;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getMen()
    {
        return men;
    }
    
    public void addMen(int men)
    {
        this.men=this.men+men;
    }
    
    
}


