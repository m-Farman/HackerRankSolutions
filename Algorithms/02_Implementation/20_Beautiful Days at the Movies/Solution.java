import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {

        int beautifulDays =0;
        for(int d=i; d<=j;d++){
            if( Math.abs(d-reverseNumber(d)) % k == 0){
                beautifulDays ++;
            }    
        }
        return beautifulDays;
    }

    static int reverseNumber(int n) {

        int reverse =0;
        while(n >0 ){
            reverse = (reverse*10) + (n%10);
            n /=10;
        }
        
        return reverse;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

