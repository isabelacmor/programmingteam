public class getmin
{
    public static void main(String [] args)
    {
        System.out.println(getmin("1000101011"));
    }

    public static int getmin(String s)
    {
		int counter = 0;
		
		String newBin = "";
		boolean tf;
		int [] powers = new int[50];
		String [] binaryPow = new String[50];
		powers[0] = 1;
		powers[1] = 5;
		
		for(int i = 2; i < powers.length; i++)
		{
			powers[i] = powers[i-1]*5; //generating first 50 powers of 5, using base cases
			//System.out.println(powers[i] + " ");
		}

		for(int i = 0; i < powers.length; i++)
		{
			binaryPow[i] = Integer.toBinaryString(powers[i]); //converting the powers of 5 into binary, storing them in another array in the same indexes
			//System.out.println(binaryPow[i] + " ");
		}
		
		//System.out.println("Given string: " + s);
		//compare binary to string; if match found, replace that set of chars with ""
		int j = 0;
		for(int i = binaryPow.length-1; i >= 0; i--)
        {
            //System.out.println("Checking against " + binaryPow[i]);
            int indexFirstInst = s.indexOf(binaryPow[i]);
            //System.out.println("IFI: " + indexFirstInst);
            
            if(indexFirstInst == 0) //this value is in the first position of the given string
            {
                tf = true;
            }
            else if(indexFirstInst != -1) //this value isn't the first pos, but it's definitely somewhere in the string
            {
				//we won't even bother checking other values, because having a 0 in front
				//of any remaining binary disqualifies the entire binary (since the whole can't be split up into other smaller binaries without leading zeros)
                if(s.substring(indexFirstInst-1, indexFirstInst).equals("0")){ return -1; }
                else{ tf = true; }
            }
            else{ tf = false; }
                    
            while(s.contains(binaryPow[i]) && tf) //while the string contains another instance of the same binary power and there is no zero in front
            {
                counter++; //increment the counter to indicate a match
                newBin = binaryPow[i]; //just storing; not really necessary
                s = s.replaceFirst(newBin, ""); //replacing matched binary in the given string with ""
                //System.out.println("Match found! " + binaryPow[i] + "; replacing with blank string");
                //System.out.println("New string: " + s);
            }
        }
		
		if(counter > 0)
		{
			return counter;
		}
		else
		{
			return -1;
		}
		
		//in another array, convert all powers to their binary; then check to see if string.contains(binaryPower); if yes, increment the counter
		//in a loop, check each string split into binary against powers[index].toBinaryString(splitString); if they equal, increment the counter
	
	}	 
}