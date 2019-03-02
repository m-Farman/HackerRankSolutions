import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
public class Solution {

     // Complete the sherlockAndAnagrams function below.

    static int sherlockAndAnagrams(String s) {

        int count = 0;
        HashMap<Integer, ArrayList<String>> allStrings = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (allStrings.containsKey(str.length())) {
                    allStrings.get(str.length()).add(str);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(str);
                    allStrings.put(str.length(), list);
                }
            }
        }

        for (Integer key : allStrings.keySet()) {
            if (allStrings.get(key).size() <= 1) {
                continue;
            }

            ArrayList<String> list = allStrings.get(key);
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (checkAnagrams(list.get(i), list.get(j))) {
                        count++;
                    }
                }

            }
        }

        return count;
    }

    static boolean checkAnagrams(String s1, String s2) {

        int[] charCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            charCount[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

