import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s=s.trim().replaceAll("[,!@_?.']", " ");
        if(s.trim().length()>0){
        String[] split=s.trim().split("\\s+");
        System.out.println(split.length);
        for(int i=0;i<split.length;i++){
            System.out.println(split[i]);
        }
        }else{
            System.out.println(0);
        }
        scan.close();
    }
}


