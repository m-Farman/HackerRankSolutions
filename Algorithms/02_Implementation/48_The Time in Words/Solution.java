import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
 
    private static final String[] clockNumber = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty","twenty one",
            "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine",
            "half" };
    
    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        StringBuilder time = new StringBuilder();
        boolean useToFlag = false;
        if (m > 30) {
            useToFlag = true;
            m = 60-m;
        }

        if (m == 0) {
            time.append(clockNumber[h] + " o' clock");
            return time.toString();
        } else if (m > 0 && m < 10) {
                if (useToFlag) {
                time.append(clockNumber[m] + " minutes ");
            } else {
                time.append(clockNumber[m] + " minute ");
            }
        } else if (m == 15 || m == 30) {
            time.append(clockNumber[m]+" ");
        } else if (m > 10 && m < 30) {
            time.append(clockNumber[m] + " minutes ");
        }

        if (useToFlag) {
            time.append("to " + clockNumber[h+1]);
        } else {
            time.append("past " + clockNumber[h]);
        }

        return time.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

