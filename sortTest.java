import java.util.*;
/**
 * Write a description of class sortTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sortTest
{
    public static void main(String [] args)
    {
        String [] array = {"a", "c", "d", "b", "e"};
        int [] nums = {1, 2, 6, 7, 3, 9, 5, 7, 4, 2, 0, 3};
        System.out.print("Original contents: ");
        Arrays.sort(array);
        Arrays.sort(nums);
        System.out.print("Sorted: ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
        }
        for(int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i]);
        }
        System.out.println("Searching: " + Arrays.asList(array).contains("d"));
        System.out.println("Searching: " + Arrays.binarySearch(nums, 3));
        System.out.println("Searching: " + Arrays.binarySearch(array, "d"));
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("d");
        arrayList.add("z");
        arrayList.add("c");
        arrayList.add("f");
        arrayList.add("e");
        arrayList.add("d");
        ArrayList arrayListNums = new ArrayList();
        arrayListNums.add(1);
        arrayListNums.add(4);
        arrayListNums.add(6);
        arrayListNums.add(2);
        arrayListNums.add(7);
        arrayListNums.add(3);
        arrayListNums.add(8);
        arrayListNums.add(0);
        for(int i=0; i<arrayList.size(); i++)
        {
            System.out.println(arrayList.get(i));
        } 
        Collections.sort(arrayList, Collections.reverseOrder());
        for(int i=0; i<arrayList.size(); i++)
        {
            System.out.println(arrayList.get(i));
        } 
        //////////////////////////////////
        Collections.sort(arrayListNums);
        for(int i=0; i<arrayListNums.size(); i++)
        {
            System.out.println(arrayListNums.get(i));
        } 
        Collections.sort(arrayListNums, Collections.reverseOrder());
        for(int i=0; i<arrayList.size(); i++)
        {
            System.out.println(arrayListNums.get(i));
        } 
        System.out.println("Searching: " + arrayList.contains("d"));
        System.out.println("Searching: " + arrayList.lastIndexOf("d"));
        System.out.println("Searching: " + arrayListNums.contains(6));
    }
}
