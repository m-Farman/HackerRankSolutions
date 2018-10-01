import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
     public static String biggerIsGreater(String w) {
        String nextWord = getNextLexicographicalWord(w);
        if (nextWord != null) {
                return nextWord;
        } else {
            return "no answer";
        }
    }
    
    public static String getNextLexicographicalWord(String w) {

        int length = w.length();
        StringBuffer word = new StringBuffer(w);
        int i = length - 2, j = length - 1;

        while (i >= 0) {
            if (word.charAt(i) < word.charAt(i + 1))
                break;
            i--;
        }

        if (i < 0) {
            return null;
        }

        while (j > i) {
            if (word.charAt(j) > word.charAt(i))
                break;
            j--;
        }
        char swap = word.charAt(i);
        word.setCharAt(i, word.charAt(j));
        word.setCharAt(j, swap);

        StringBuffer output = new StringBuffer();
        for (int k = 0; k <= i; k++) {
            output.append(word.charAt(k));
        }
        for (int k = length - 1; k > i; k--) {
            output.append(word.charAt(k));
        }
        return output.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

