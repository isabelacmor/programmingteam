
public class testingSort {
	public static void main(String [] main)
	{
	
		int [] array = {5, 6, 9, 10, 2, 4, 1};
		int i, j;
		
		for (i = 0 ; i < array.length; i++)
	    {
	    for (j = i+1 ; j < array.length; j++)
	    {
				if (array[i] > array[j])
				{
					int x = array[i];
					array[i] = array[j];
					array[j] = x;
				}
			}
		}
		
		for(i = 0; i  < array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
}
