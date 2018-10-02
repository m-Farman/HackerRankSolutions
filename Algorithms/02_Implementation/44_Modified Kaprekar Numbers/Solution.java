import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

     // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {

        StringBuilder output = new StringBuilder();
        long result = 0;
        for (long i = p; i <= q; i++) {
            int numberSize = stringSize(i);
            result = i * i;
            String sqrt = String.valueOf(result);
            int firstNo = 0;
            if (sqrt.length() != numberSize) {
                firstNo = Integer.parseInt(sqrt.substring(0, sqrt.length() - numberSize));
            }
            int secondNo = Integer.parseInt(sqrt.substring(sqrt.length() - numberSize));

            if (i == (firstNo + secondNo)) {
                output.append(i + " ");
            }
        }
        String o = output.toString().trim();
        if (o.length() == 0) {
            System.out.println("INVALID RANGE");
        } else {
            System.out.println(o);
        }

    }

    final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };

    // Requires positive x
    static int stringSize(long x) {
        for (int i = 0;; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}

