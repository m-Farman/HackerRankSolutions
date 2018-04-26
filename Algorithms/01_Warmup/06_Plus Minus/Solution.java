import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the plusMinus function below.
     */
    static void plusMinus(int[] arr) {
        double positive=0,negative=0,zeroes=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                positive++;
            }else if(arr[i]<0){
                negative++;
            }else{
                zeroes++;
            }
       }
        
        DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(6);

        System.out.println(df.format(positive/arr.length));
        System.out.println(df.format(negative/arr.length));
        System.out.println(df.format(zeroes/arr.length));
        
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        plusMinus(arr);
    }
}

