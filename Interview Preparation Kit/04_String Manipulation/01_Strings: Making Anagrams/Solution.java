import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;

//https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {


        Map<Character, Long> aCount = a.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> bCount = new HashMap<>();

        long count = 0;
        for (int i = 0; i < b.length(); i++) {
            Character ch = b.charAt(i);
            if (aCount.containsKey(ch)) {
                count = aCount.get(ch);
                if (count == 1l)
                    aCount.remove(ch);
                else
                    aCount.put(ch, count - 1);

            } else {
                count = 1;
                if (bCount.containsKey(ch)) {
                    count = bCount.get(ch) + 1;
                }
                bCount.put(ch, count);
            }
        }
        int output = 0;
        for (Long value : aCount.values()) {
            output += value;
        }
        for (Long value : bCount.values()) {
            output += value;
        }

        return output;
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

