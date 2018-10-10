import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {


        int[][] g = new int[grid.length][grid.length];

        boolean spaceFlage=false;
         for (int i = 0; i < grid.length; i++) {
             if(grid[i].contains(" ")) spaceFlage=true;
            String input = grid[i].replace(" ", "");
            for (int j = 0; j < input.length(); j++) {
                g[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }

        for (int i = 1; i < g.length - 1; i++) {
            for (int j = 1; j < g.length - 1; j++) {
                if (g[i][j] > g[i - 1][j] && g[i][j] > g[i + 1][j] && g[i][j] > g[i][j - 1] && g[i][j] > g[i][j + 1]) {
                    g[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < g.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < g.length; j++) {
                if (g[i][j] == Integer.MAX_VALUE) {
                    s.append("X");
                } else {
                    s.append(g[i][j]);
                }
                 if (j != g.length - 1 && spaceFlage) {
                    s.append(" ");
                }
            }
            grid[i] = s.toString();
        }

        return grid;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

