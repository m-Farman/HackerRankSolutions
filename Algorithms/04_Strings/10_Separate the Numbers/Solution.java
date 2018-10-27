import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
int nSize = 1;
        boolean notFound = false;
        while (nSize <= s.length() / 2) {
            Long firstNo = Long.parseLong(s.substring(0, nSize));
            int index = nSize, i = 1;
            String st = String.valueOf(firstNo + i++);
            notFound = false;
            while (index + st.length() - 1 < s.length()) {
                if (!st.equals(s.substring(index, index + st.length()))) {
                    notFound = true;
                    break;
                }
                index += st.length();
                st = String.valueOf(firstNo + i++);

            }
            nSize++;
            if (!notFound && index == s.length()) {
                System.out.println("YES " + firstNo);
                return;
            }
        }
        System.out.println("NO");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}

