import java.io.*;
import java.util.*;
import java.awt.*;

public class lineSeg{
	
	public lineSeg()
	{
		line1 = new Line2D.Double(15.0, 10.0, 50.0, 25.0);
		line2 = new Line2D.Double(35.0, 5.0, 30.0, 30.0);
		intersects(line1, line2);
	}
}