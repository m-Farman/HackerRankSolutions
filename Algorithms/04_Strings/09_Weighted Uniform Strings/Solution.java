import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        String[] output = new String[queries.length];
        int[] alphabetCount = new int[27];
        char previous = ' ';
        char ch = ' ';
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (previous == ch) {
                count++;
            } else {
                count = 1;
                previous = ch;
            }
            alphabetCount[ch - 96] = Math.max(alphabetCount[ch - 96], count);
        }

        for (int i = 0; i < queries.length; i++) {
            for (int j = 1; j < alphabetCount.length; j++) {
                if (queries[i] % j == 0 && alphabetCount[j] * j >= queries[i]) {
                    output[i] = "Yes";
                    break;
                }
                if (output[i] == null) {
                    output[i] = "No";
                }
            }
        }
    return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

