import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scan.nextLine().split(" ");

        int n = Integer.parseInt(nd[0].trim());

        int d = Integer.parseInt(nd[1].trim());

        int[] a = new int[n];
        int[] o = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }
        int j=0;
        for(int i=d;i<n;i++){
         o[j++]=a[i];   
        }
        for(int i=0;i<d;i++){
            o[j++]=a[i];
        }
        
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++){
            sb.append(o[i]+" ");
        }
        
        System.out.println(sb.toString().trim());
        
    }
}

