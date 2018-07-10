import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String leapYear= "12.09.";
    static String nonLeapYear= "13.09.";
    static String changingYear= "26.09.1918";
    // Complete the solve function below.
    static String solve(int year) {
       
		String output = null;
		if (year > 1918) {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				output = leapYear + year;
			} else {
				output = nonLeapYear + year;
			}
		}else if (year < 1918) {
			if (year % 4 == 0) {
				output = leapYear + year;
			} else {
				output = nonLeapYear + year;
			}
		}else {
			output = changingYear;
		}
		
		return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = solve(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

