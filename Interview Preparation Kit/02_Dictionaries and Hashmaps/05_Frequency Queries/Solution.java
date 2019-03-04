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

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {
        

        List<Integer> output = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> countToNumber = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int queryType = queries[i][0];
            int number = queries[i][1];
            if (queryType == 1) {

                int c = 1;
                if (count.containsKey(number)) {
                    c = count.get(number);
                    countToNumber.get(c).remove(number);
                    c++;
                }
                count.put(number, c);
                if (countToNumber.containsKey(c)) {
                    countToNumber.get(c).add(number);
                } else {
                    HashSet<Integer> l = new HashSet<>();
                    l.add(number);
                    countToNumber.put(c, l);
                }

            } else if (queryType == 2) {

                if (!count.containsKey(number)) {
                    continue;
                }
                int c = count.get(number);
                countToNumber.get(c).remove(number);
                c = c - 1;
                if (countToNumber.containsKey(c)) {
                    countToNumber.get(c).add(number);
                } else {
                    HashSet<Integer> l = new HashSet<>();
                    l.add(number);
                    countToNumber.put(c, l);
                }

                 if (c<1) {
                    count.remove(number);
                }else {
                    count.put(number, c);    
                }
            } else {

                if (number==0  || (countToNumber.containsKey(number) && countToNumber.get(number).size() > 0)) {
                    output.add(1);
                } else {
                    output.add(0);
                }
            }
        }

        return output;
        }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in))) {
            
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];
           
            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }
          
            List<Integer> ans = freqQuery(queries);
          
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(System.getenv("OUTPUT_PATH")))) {
            
                bufferedWriter.write(ans.stream().map(Object::toString)
                            .collect(joining("\n")) + "\n");
            }
        }
    }
}

