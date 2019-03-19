import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static int[] countArr = new int[201];

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int i = 0, noticeSent = 0;
        for (; i < d; i++) {
            countArr[expenditure[i]]++;
        }

        while (i < expenditure.length) {
            double median = getMedian(countArr, d);
            if (expenditure[i] >= 2 * median) {
                noticeSent++;
            }
            countArr[expenditure[i]]++;
            countArr[expenditure[i - d]]--;
            i++;
        }

        return noticeSent;

    }

   private static double getMedian(int[] freq, int d) {
        if (d % 2 == 1) {
            int center = 0;
            for (int i = 0; i < freq.length; i++) {
                center = center + freq[i];

                if (center > d / 2) {
                    return i;
                }
            }
        } else {
            int count = 0;
            int first = -1;
            int second = -1;
            for (int i = 0; i < freq.length; i++) {
                count = count + freq[i];

                if (count == d / 2) {
                    first = i;
                } else if (count > d / 2) {
                    if (first < 0)
                        first = i;
                    second = i;

                    return ((float) first + (float) second) / 2.0;
                }
            }
        }
        return 0;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

