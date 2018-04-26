import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the birthdayCakeCandles function below.
     */
    static int birthdayCakeCandles(int n, int[] ar) {
        
        HashMap<Integer,Integer> candleCount=new HashMap<Integer,Integer>();
        int maxHeight=0;
        for(int i=0;i<ar.length;i++){
            if(maxHeight < ar[i])
                maxHeight = ar[i];
            if(candleCount.get(ar[i])==null)
                candleCount.put(ar[i],1);
            else
                candleCount.put(ar[i],candleCount.get(ar[i])+1);
        }
        
        return candleCount.get(maxHeight);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] ar = new int[n];

        String[] arItems = scan.nextLine().split(" ");

        for (int arItr = 0; arItr < n; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = birthdayCakeCandles(n, ar);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
    }
}

