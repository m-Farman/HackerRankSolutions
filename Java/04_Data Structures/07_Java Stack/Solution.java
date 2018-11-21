import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            System.out.println(ischeckBalancedBrackets(input));
		}
		
	}
private static boolean ischeckBalancedBrackets(String string) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.peek();
                if ((ch == ')' && last == '(') || (ch == '}' && last == '{') || (ch == ']' && last == '[')) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty() ? true : false;
    }
}




