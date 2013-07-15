import java.io.*;
import java.util.*;
 
/**
 * Write a description of class music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class music
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        ArrayList <String> sharps = new ArrayList();
        sharps.add("A");
        sharps.add("A#");
        sharps.add("B");
        sharps.add("C");
        sharps.add("C#");
        sharps.add("D");
        sharps.add("D#");
        sharps.add("E");
        sharps.add("F");
        sharps.add("F#");
        sharps.add("G");
        sharps.add("G#");
        ArrayList <String> flats = new ArrayList();
        flats.add("A");
        flats.add("Bb");
        flats.add("B");
        flats.add("Cb");
        flats.add("C");
        flats.add("Db");
        flats.add("D");
        flats.add("Eb");
        flats.add("E");
        flats.add("Fb");
        flats.add("F");
        flats.add("Gb");
        flats.add("G");
        String line = in.nextLine();
        String blank;
        int steps;
        
        while(!line.equals("***"))
        {
            String [] notesAr = line.split(" ");
            ArrayList <String> notes = new ArrayList();
            Collections.addAll(notes, notesAr);
            steps = in.nextInt();
            int usingIndex, newIndex;
            
            for(int i = 0; i < notes.size(); i++)
            {
                if(notes.contains("E#") || notes.contains("B#"))
                { 
                    for(int m = 0; m < notes.size(); m++)
                    {
                        if(notes.get(m).equals("E#"))
                        {
                            notes.set(m, "F");
                        }
                        else if(notes.get(m).equals("B#"))
                        {
                            notes.set(m, "C");
                        }
                    }
                }
                
                if(notes.get(i).length() == 1 || notes.get(i).substring(1).equals("#"))
                {
                    usingIndex = sharps.indexOf(notes.get(i));
                    //System.out.print("looking at note: " + notes.get(i) + " note is in: " + usingIndex + " in first if ");
                    newIndex = usingIndex+steps;
                    //System.out.print(" newIndex is: " + newIndex);
                    if(newIndex > sharps.size()-1)
                    {
                        newIndex = newIndex-sharps.size();
                    }
                    else if(newIndex < 0)
                    {
                        newIndex = sharps.size() + newIndex;
                    }
                    //System.out.print(" updated newIndex is: " + newIndex);
                    System.out.print(sharps.get(newIndex) + " ");
                }
                else if(notes.get(i).substring(1).equals("b"))
                {
                    usingIndex = flats.indexOf(notes.get(i));
                    //System.out.print("note is in: " + usingIndex + " in second if ");
                    newIndex = usingIndex+steps;
                    if(newIndex > flats.size()-1)
                    {
                        newIndex = newIndex-flats.size();
                    }
                    else if(newIndex < 0)
                    {
                        newIndex = flats.size() + newIndex;
                    }
                    System.out.print(flats.get(newIndex) + " ");
                }
            }
            //check for index position given-step in sharps; 
            //if not in sharps, check in flats
            System.out.println();
            //regenerating values
            blank = in.nextLine();
            line = in.nextLine();
        }
    }
}
