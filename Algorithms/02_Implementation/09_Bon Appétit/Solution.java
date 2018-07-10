import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
       BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        int n =Integer.parseInt(input[0]);
        int k =Integer.parseInt(input[1]);
        input =br.readLine().split(" ");
        int b =Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=0;i < input.length;i++){
            if( i==k )
              continue;
            sum +=Integer.parseInt(input[i]);
        }
        
        sum = sum / 2;
        if(sum == b){
            System.out.println("Bon Appetit");
        }else{
            System.out.println(b-sum);
        }
    }
}
