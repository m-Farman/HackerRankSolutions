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

//https://www.hackerrank.com/challenges/count-triplets-1/problem
public class Solution {

    // Complete the countTriplets function below.
     static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        Map<Long, Long> firstHalf = new HashMap<>();
        Map<Long, Long> secondHalf = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Long number : arr) {

            if (secondHalf.get(number) > 1) {
                secondHalf.put(number, secondHalf.get(number) - 1);
            } else {
                secondHalf.remove(number);
            }
             if (number % r == 0) {
                long prev = number / r;
                long after = number * r;
                if (firstHalf.containsKey(prev) && secondHalf.containsKey(after)) {
                    count += firstHalf.get(prev) * secondHalf.get(after);
                }
            }

            long occurence = 1;
            if (firstHalf.containsKey(number)) {
                occurence = firstHalf.get(number) + 1;
            }
            firstHalf.put(number, occurence);

        }

        return count;
    
     }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

