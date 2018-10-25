import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pangrams function below.
    static String pangrams(String s) {
    int[] aToz = new int[26];
        s = s.replaceAll("\\s+", "").toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            aToz[s.charAt(i) - 97] = 1;
        }
        for (int i = 0; i < aToz.length; i++) {
            if (aToz[i] != 1) {
                return "not pangram";
            }
        }
        return "pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

