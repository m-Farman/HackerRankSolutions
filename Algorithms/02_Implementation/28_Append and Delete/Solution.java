import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
   static String appendAndDelete(String s, String t, int k) {

        if (s.equals(t) && ((k >= s.length() * 2) || k % 2 == 0)) {
            return "Yes";
        }
        int index = 0;
        while (index < s.length() && index < t.length()) {
            if (s.charAt(index) != t.charAt(index)) {
                break;
            }
            index++;
        }

        int l1 = 0, l2 = 0;
        l1 = index < s.length() ? s.length() - index : 0;
        l2 = index < t.length() ? t.length() - index : 0;
       
        if ((l1 == 0 || l2 == 0) && !((k - l1 + l2) % 2 == 0 || k > s.length() + t.length())) {
            return "No";
        } else if (k >= l1 + l2) {
            return "Yes";
        } else {
            return "No";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

