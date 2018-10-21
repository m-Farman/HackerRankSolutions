import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
RegEx Breakup:

^: Start
([a-z]): Match first letter in capturing group #1
(?!\1): Lookahead to make sure we don't match same letter again
([a-z]): Match second letter in capturing group #3
(?:\1\2)*: Match zero or more pairs of first and second letter
\1?: Match optional first letter before end
$: End

*/

public class Solution {

    // Complete the alternate function below.
    static int alternate(String s) {
 List<Character> unique = s.chars().mapToObj(c -> (char) c).distinct().collect(Collectors.toList());

        int maxSize = 0;
        for (int i = 0; i < unique.size() - 1; i++) {
            for (int j = i + 1; j < unique.size(); j++) {
                String char2String = s.replaceAll("[^" + unique.get(i) + unique.get(j) + "]", "");
                if (char2String.matches("^([a-z])(?!\\1)([a-z])(?:\\1\\2)*\\1?$")) {
                    maxSize = Math.max(maxSize, char2String.length());
                }

            }
        }

        return maxSize;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

