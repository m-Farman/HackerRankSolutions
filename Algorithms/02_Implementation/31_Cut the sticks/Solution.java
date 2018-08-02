import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        List<Integer> noOfSticks=new ArrayList();
        int min=Integer.MAX_VALUE;
        for(int i=0;i< arr.length;i++){
            if(min > arr[i])
                min = arr[i];
        }
        int nextMin = Integer.MAX_VALUE , no = 0;
        do{
            nextMin=Integer.MAX_VALUE;
            no =0;
            for(int i=0;i< arr.length;i++){
                if(arr[i]==0)
                 continue;
                arr[i] -= min;
                no++;
                if (arr[i]!=0 && nextMin > arr[i])
                    nextMin = arr[i];
            }
            min = nextMin;
            if(no!=0)
             noOfSticks.add(no);
        }while(no!=0);

        int[] result = new int[noOfSticks.size()];
        for(int i=0;i<result.length;i++){
            result[i] =noOfSticks.get(i);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

