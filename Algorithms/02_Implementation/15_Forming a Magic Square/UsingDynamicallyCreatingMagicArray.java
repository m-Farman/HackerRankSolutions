import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int[][] sq = new int[3][3];
		ArrayList<int[][]> magic = new ArrayList<>();
		HashSet<Integer> unique = new HashSet<>();
		permute2dArray(sq, 0, 0, magic, unique);

		int[] diff = new int[magic.size()];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < diff.length; k++) {
					diff[k] += Math.abs(magic.get(k)[i][j] - s[i][j]);
				}
			}
		}
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < diff.length; i++) {
			if (diff[i] < minDiff) {
				minDiff = diff[i];
			}
		}
		
        return minDiff;

    }
static void permute2dArray(int[][] sq, int row, int col, ArrayList<int[][]> magic, Set<Integer> unique) {

		if (row == 3) {
			return;
		}
		int r = 0, c = 0;
		for (int i = 1; i <= 9; i++) {

			if (!unique.add(i)) {
				continue;
			}
			sq[row][col] = i;
			checkMagic(sq, magic);

			if (col + 1 >= 3) {
				c = 0;
				r = row + 1;
			} else {
				c = col + 1;
				r = row;
			}
			permute2dArray(sq, r, c, magic, unique);
			unique.remove(i);
		}

	}

	static void checkMagic(int[][] sq, ArrayList<int[][]> magic) {

		HashSet<Integer> sum = new HashSet<>();
		int rowS = 0, colS = 0, daigonalL = 0, daigonalR = 0;
		for (int i = 0; i < sq.length; i++) {
			rowS = 0;
			colS = 0;
			for (int j = 0; j < sq.length; j++) {
				rowS += sq[i][j];
				colS += sq[j][i];
			}
			sum.add(rowS);
			sum.add(colS);
			daigonalL += sq[i][i];
			daigonalR += sq[i][2 - i];
		}

		sum.add(daigonalL);
		sum.add(daigonalR);

		if (sum.size() == 1) {
			int[][] tmp = new int[3][3];
			for (int i = 0; i < tmp.length; i++) {
				for (int j = 0; j < tmp.length; j++) {
					tmp[i][j] = sq[i][j];
				}
			}
			magic.add(tmp);
		}
	}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

