import java.io.*;
import java.util.*;

public class strip {
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		String line = in.nextLine();
		line = line.replaceAll("\"", "");
		line = line.replaceAll(",", " ");
		
		System.out.println(line);
	}
}
