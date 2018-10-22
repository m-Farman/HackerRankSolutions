import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the absolutePermutation function below.
    static String absolutePermutation(int n, int k) {
        int[] a = new int[n + 1];
        if (k > 0 && n % (2 * k) != 0) {
            return "-1";
        }

        int diff = k;
        for (int i = 1; i < a.length; i ++) {
            a[i] = i + diff;
            if (k > 0 && i % k == 0) {
                diff *= -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < a.length; i++) {
            sb.append(a[i] + " ");
        }

        return sb.toString().trim();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            String result = absolutePermutation(n, k);

           
           bufferedWriter.write(result);
           
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

