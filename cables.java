import java.io.*;
import java.util.*;

/* VPW Template */

public class cables
{

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException
    {
        new cables().start();
    	/*Scanner in = new Scanner(System.in);
    	int numPoints = in.nextInt();
    	int [] citiesX = new int[numPoints];
    	int [] citiesY = new int[numPoints];
    	
    	for (int i = 0; i < numPoints; i++)
        {
            citiesX[i] = in.nextInt();
            citiesY[i] = in.nextInt();
        }
    	
    	computeAllDistances();
        solve();
        System.out.println(String.format("%.2f", shortest));*/
    }


    public float startX, startY;
    public int cityCount;
    public float citiesX[], citiesY[];
    public float distances[];
    public float shortest = Float.MAX_VALUE;

    public void start() throws IOException
    {
        /* Read the stuff */
        Scanner br = new Scanner(System.in);
        String[] input = new String[Integer.parseInt(br.nextLine())];
        while(br.hasNext())
        {
        cityCount = input.length;
        citiesX = new float[input.length];
        citiesY = new float[input.length];
        for (int i = 0; i < input.length-1; ++i)
        {
            input[i] = br.nextLine();
            String line = (input[i]);
            String[] lineElements = line.split(" ");
            float x = Float.parseFloat(lineElements[0]);
            float y = Float.parseFloat(lineElements[1]);
            citiesX[i] = x;
            citiesY[i] = y;
        }
        /* Read current position */
        String line = (br.nextLine());
        String[] lineElements = line.split(" ");
        startX = Float.parseFloat(lineElements[0]);
        startY = Float.parseFloat(lineElements[1]);
        /* Compute distances */
        computeAllDistances();
        solve();
        System.out.println(String.format(Locale.US, "%.2f", shortest));
        }
    }

    public void solve()
    {
        for (int i = 1; i <= cityCount; ++i)
        {
            boolean[] wentTo = new boolean[cityCount];
            wentTo[i - 1] = true;
            step(wentTo, i, distances[distanceIndex(0, i)]);
        }
    }

    public void step(boolean[] wentTo, int currentCity, float distance)
    {
        int wentToCount = 0;
        for (int i = 1; i <= cityCount; ++i)
        {
            if (wentTo[i - 1])
            {
                ++wentToCount;
                continue;
            }
            boolean[] copy = new boolean[cityCount];
            System.arraycopy(wentTo, 0, copy, 0, cityCount);
            copy[i - 1] = true;
            float dist = distance + distances[distanceIndex(currentCity, i)];
            step(copy, i, dist);
        }
        if (wentToCount == cityCount)
        {
            if (shortest > distance)
            {
                shortest = distance;
            }
        }
    }

    public void computeAllDistances()
    {
//      int count = (int) countDistances(cityCount + 1);
//      System.out.println("Compute Distances (" + count + ")");
        distances = new float[cityCount * cityCount];
        for (int i = 0; i <= cityCount; ++i)
        {
            for (int j = i + 1; j <= cityCount; ++j)
            {
                float x1, y1, x2, y2;
                if (i == 0)
                {
                    x1 = startX;
                    y1 = startY;
                } else
                {
                    x1 = citiesX[i - 1];
                    y1 = citiesY[i - 1];
                }
                x2 = citiesX[j - 1];
                y2 = citiesY[j - 1];
                float xDiff = x1 - x2;
                float yDiff = y1 - y2;
                float dist = (float) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
//              System.out.printf("Distance (%d, %d)(%d) = %f\n", i, j, distanceIndex(i, j), dist);
                distances[distanceIndex(i, j)] = dist;
            }
        }
    }

    public int distanceIndex(int c1, int c2)
    {
        if (c1 == c2)
            throw new IllegalArgumentException("Cities are the same! (" + c1 + ")");
        if (c1 < c2)
        {
            return c1 * cityCount + c2 - 1;
        } else
        {
            return c2 * cityCount + c1 - 1;
        }
    }

    public long countDistances(long l)
    {
        if (l == 0 || l == 1)
            return 0;
        return (l - 1) + countDistances(l - 1);
    }

}