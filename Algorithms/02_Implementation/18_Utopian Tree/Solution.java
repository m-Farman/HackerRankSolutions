import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int[] h = new int[61]; 
    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        return h[n];
    }

    static void populateHeight(){
       
        for(int i=0;i <h.length;i++){
            if( i==0){
                h[i]=1;                
                continue;
            }
            if( i%2 == 0){
                h[i] =h[i-1]+1; 
            }else{
                h[i] = h[i-1]* 2; 
            }  
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        populateHeight();
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

