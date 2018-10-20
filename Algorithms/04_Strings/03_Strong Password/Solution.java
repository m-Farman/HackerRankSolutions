import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
 boolean isLowerCase = false, isUpperCase = false, isSymbol = false, isNumber = false;
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= 48 && ch <= 57) {
                isNumber = true;
            } else if (ch >= 65 && ch <= 90) {
                isUpperCase = true;
            } else if (ch >= 97 && ch <= 122) {
                isLowerCase = true;
            } else if ("!@#$%^&*()-+".contains(ch + "")) {
                isSymbol = true;
            }
        }

        if (!isNumber) {
            count++;
        }
        if (!isSymbol) {
            count++;
        }
        if (!isUpperCase) {
            count++;
        }
        if (!isLowerCase) {
            count++;
        }

        return count + n >= 6 ? count : count + (6 - (n + count));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

