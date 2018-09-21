import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        StringBuffer sb=new StringBuffer(A);
        System.out.println(sb.reverse().toString().equals(A)?"Yes":"No");
        
    }
}




