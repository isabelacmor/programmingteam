
/**
 * Tester tests the BeadedJava class. 
 * 
 * ©FLVS 2007
 * @author R. Enger 
 * @version 5/10/07
 */
import java.util.*;
public class HomeworkTester3
{
   public static void main(String []args)
    {
        //I had no idea what the instructions meant by 
        //"Use an ArrayList of type Homework to test your class."
        int pages = 5;
        //-----arraylist
        List <Homework3> tester = new ArrayList();
        tester.add(new MyMath3());
        tester.add(new MyScience3());
        tester.add(new MyEnglish3());
        tester.add(new MyJava3());
        //-----subjects
//         MyMath2 math = new MyMath2();
//         MyScience2 science = new MyScience2();
//         MyEnglish2 english = new MyEnglish2();
//         MyJava2 java = new MyJava2();
        //-----creating assignments with the arraylist
        tester.get(0).createAssignment(pages);
        //pages += 2;
        tester.get(1).createAssignment(pages);
        pages += pages;
        tester.get(2).createAssignment(pages);
        pages = (pages*2)/3;
        tester.get(3).createAssignment(pages);
        //-----creating assignments
               
        System.out.println();
        System.out.println(tester.get(0));
        System.out.println();
        System.out.println(tester.get(1));
        System.out.println();
        System.out.println(tester.get(2));
        System.out.println();
        System.out.println(tester.get(3));
        
//         int release = tester.get(0).compareTo(tester.get(1));
//         System.out.println("\n\n" + release);
//         if(release == 0)
//         {
//             System.out.println(tester.get(0) + "'s required number of pages is equal to " + tester.get(1) + "'s required number of pages for homework.");
//         }
//         else
//             System.out.println("NOT EQUAL");
        
        for(int i = 0; i < 4; i++)
        {
            for(int j = 1; j < 4; j++)
            {
                int release = tester.get(i).compareTo(tester.get(j));
                if(release == 0 && (tester.get(i) != tester.get(j)))
                {
                    System.out.println(tester.get(i).getHWType() + "'s required reading is equal to " + tester.get(j).getHWType() + "'s required reading");
                }
                //else
                    //System.out.println("Not Equal");
            }
        }
   }
}