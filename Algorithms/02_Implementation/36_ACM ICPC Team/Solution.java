import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {

        String firstMember = null, secondMember = null;
        int max = -1, pair = 0;
        for (int i = 0; i < topic.length - 1; i++) {
            firstMember = topic[i];
            for (int j = i + 1; j < topic.length; j++) {
                secondMember = topic[j];
                int count = 0;
                for (int k = 0; k < firstMember.length(); k++) {
                    if ((Integer.parseInt(firstMember.charAt(k) + "")
                            | Integer.parseInt(secondMember.charAt(k) + "")) == 1) {
                        count++;
                    }
                }
                if (max < count) {
                    max = count;
                    pair = 1;
                } else if (max == count) {
                    pair++;
                }

            }
        }
        return new int[] { max, pair };

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

