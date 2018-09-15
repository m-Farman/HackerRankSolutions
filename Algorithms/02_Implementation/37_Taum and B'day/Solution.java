import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TaumBday {

    // Complete the taumBday function below.
    static long taumBday(long b, long w, long bc, long wc, long z) {

        long fw = wc, fb = bc;

        if (bc > wc + z) {
            fb = wc + z;
        }

        if (wc > bc + z) {
            fw = bc + z;
        }

        long total = (b * fb) + (w * fw);

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
         BufferedWriter bufferedWriter = new BufferedWriter(new
         FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] bw = scanner.nextLine().split(" ");

            long b = Integer.parseInt(bw[0]);

            long w = Integer.parseInt(bw[1]);

            String[] bcWcz = scanner.nextLine().split(" ");

            long bc = Integer.parseInt(bcWcz[0]);

            long wc = Integer.parseInt(bcWcz[1]);

            long z = Integer.parseInt(bcWcz[2]);

            long result = taumBday(b, w, bc, wc, z);

            System.out.println(result);
             bufferedWriter.write(String.valueOf(result));
             bufferedWriter.newLine();
        }

         bufferedWriter.close();

        scanner.close();
    }
}

