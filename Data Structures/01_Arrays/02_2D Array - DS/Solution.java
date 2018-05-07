import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the array2D function below.
     */
    static int array2D(int[][] arr) {
        
        int i=0,j=0,maxSum=Integer.MIN_VALUE,sum=0;
        while(i+2 < arr.length){
            j=0;
            while(j+2 < arr.length){
                
                sum=0;
                for(int k=j;k<=j+2;k++){
                    sum +=arr[i][k];
                    sum +=arr[i+2][k];
                }
                
                sum +=arr[i+1][j+1];
                if(maxSum < sum )
                    maxSum=sum;
                j++;
            }
            i++;
        }
    return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int arrRowItr = 0; arrRowItr < 6; arrRowItr++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            for (int arrColumnItr = 0; arrColumnItr < 6; arrColumnItr++) {
                int arrItem = Integer.parseInt(arrRowItems[arrColumnItr].trim());
                arr[arrRowItr][arrColumnItr] = arrItem;
            }
        }

        int result = array2D(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

