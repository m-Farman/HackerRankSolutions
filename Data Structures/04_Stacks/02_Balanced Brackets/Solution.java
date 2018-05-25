import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String isBalanced(String s) {
        
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> closeBrakets = new HashMap<>();
		closeBrakets.put('}', '{');
		closeBrakets.put(']', '[');
		closeBrakets.put(')', '(');

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '}' || ch == ']' || ch == ')') {
				if (!stack.isEmpty() && stack.peek() == closeBrakets.get(ch)) {
					stack.pop();
					continue;
				} else {
					return "NO";
				}
			}
			stack.push(ch);
		}

		return stack.isEmpty() ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

