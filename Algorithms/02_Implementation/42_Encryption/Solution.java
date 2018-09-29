import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replaceAll("\\s+", "");
        if (s.length() < 1) {
            return "";
        }
        double sqrt = Math.sqrt(s.length());
        int row = (int) Math.floor(sqrt);
        int col = (int) Math.ceil(sqrt);

        char[] input = s.toCharArray();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int k = i; k < input.length; k += col) {
                output.append(input[k]);
            }
            output.append(" ");
        }
    
        return output.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

