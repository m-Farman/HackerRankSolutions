import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
      StringBuilder output = new StringBuilder();
        LinkedList<Character> q = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!q.isEmpty() && q.peekLast() == s.charAt(i)) {
                q.removeLast();
            } else {
                q.addLast(s.charAt(i));
            }
        }
        for (char c : q) {
            output.append(c);
        }
        return output.toString().isEmpty() ? "Empty String" : output.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

