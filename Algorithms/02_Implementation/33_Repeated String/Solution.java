import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int[] aCount = new int[s.length()];
        aCount[0] = s.charAt(0) == 'a' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            aCount[i] = aCount[i - 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }

        long times = (n / s.length()) * aCount[s.length() - 1];
        times += n % s.length() != 0 ? aCount[(int) ((n % s.length()) - 1)] : 0;

        return times;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

