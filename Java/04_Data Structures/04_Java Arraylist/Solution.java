import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) { list.add(Arrays.asList(br.readLine().split("\\s+")).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            if (list.size() >= row && list.get(row - 1).size() > col) {
                System.out.println(list.get(row-1).get(col));
            }else {
                System.out.println("ERROR!");
            }
        }
    }
}
