

/**
 * BasicJean is a basic pair of jeans
 * 
 * ©FLVS 2007
 * @author R. Enger 
 * @version 5/10/2007
 */
public abstract class Homework3 implements Comparable<Homework3>
{
    // instance variables - replace the example below with your own
    private int myPagesRead;
    private String typeHW;
    /**
     * Constructor for objects of class basicJean
     */
    public Homework3()
    {
        // initialise instance variables
        myPagesRead = 0;
        typeHW = "none";
    }
    public abstract void createAssignment(int p);
    public int getPagesRead()
    {
        return myPagesRead;
    }
    public void setPagesRead(int n)
    {
        myPagesRead = n;
    }
    public String getHWType()
    {
        return typeHW;
    }
    public void setHWType(String hw)
    {
        typeHW = hw;
    }
    public int compareTo(Homework3 obj)
    {
        if(myPagesRead < obj.myPagesRead)
            return -1;
        else if(myPagesRead == obj.myPagesRead)
            return 0;
        else
            return 1;
    }
}
