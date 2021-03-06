import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
               
        if(s.startsWith("12") && s.endsWith("AM")){
            s=s.replace("12","00");
        }
        
        if(s.endsWith("PM") && !s.startsWith("12")){
           int hour=Integer.parseInt(s.substring(0,s.indexOf(":")));     
           hour +=12;
           s=hour+s.substring(s.indexOf(":"));
         }
        
        s=s.substring(0,s.length()-2);
        
        return s;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

