import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
Map<Character, Long> charCount = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Long, Integer> freqTochar = new HashMap<>();
        int count = 0;
        for (Map.Entry<Character, Long> entry : charCount.entrySet()) {
            count = 1;
            if (freqTochar.containsKey(entry.getValue())) {
                count = freqTochar.get(entry.getValue()) + 1;
            }

            freqTochar.put(entry.getValue(), count);
            if (freqTochar.size() > 2) {
                return "NO";
            }
        }

        Map.Entry<Long, Integer> output = freqTochar.entrySet().stream().filter(e -> e.getValue() == 1 && e.getKey() % 2 == 1).findAny()
                .orElse(null);
        if (output != null && output.getKey() - 1 != 0) {
            output = freqTochar.containsKey(output.getKey() - 1) ? output : null;
        }
        return (freqTochar.size()==1 || output != null) ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

