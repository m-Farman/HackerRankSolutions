import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
int[][] matrix = new int[a.length() + 1][b.length() + 1];

        matrix[0][0] = 1;
        boolean capsFound = false;
        for (int i = 1; i <= a.length(); i++) {

           if ((a.charAt(i - 1) >= 65 && a.charAt(i - 1) <= 90) || capsFound) {
                capsFound = true;
                matrix[i][0] = 0;
            }else {
                matrix[i][0] = 1;
            }
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else if (a.charAt(i - 1) - 32 == b.charAt(j - 1)) {
                    matrix[i][j] = Math.max(matrix[i - 1][j - 1], matrix[i - 1][j]);
                } else if (a.charAt(i - 1) <= 90 && a.charAt(i - 1) >= 65) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }

            }

        }

        return matrix[a.length()][b.length()] == 1 ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

