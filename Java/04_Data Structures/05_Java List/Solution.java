import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(Arrays.asList(br.readLine().split("\\s+")));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if ("Insert".equals(br.readLine())) {
                String[] input = br.readLine().split("\\s+");
                list.add(Integer.parseInt(input[0]), input[1]);
            } else {
                list.remove(Integer.parseInt(br.readLine()));
            }
        }
        StringBuilder output = new StringBuilder();
        for (String string : list) {
            output.append(string + " ");
        }
        System.out.print(output.toString().trim());
    }
}


