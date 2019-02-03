
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * 
 * remove the contiguous occurring element which satisfy the given threshold 
 * */
public class Solution {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("a", "b", "c", "d", "e", "e", "e", "e", "d", "d", "c", "b", "f", "g", "f");

		System.out.println(input);
		System.out.println(getShrunkArray(input, 3));
	}

	public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {

		int count = 0, size = inputArray.size();
		Stack<String> shrunkHelper = new Stack<>();
		String tmp = null;
		for (int i = 0; i < size; i++) {
			tmp = inputArray.get(i);
			if (shrunkHelper.isEmpty()) {
				shrunkHelper.push(tmp);
				continue;
			}

			if (tmp.equals(shrunkHelper.peek())) {
				count = 2;
				int next = i + 1;
				while (next < size && tmp.equals(inputArray.get(next))) {
					next++;
					count++;
				}
				int popCount = 1;
				String last = shrunkHelper.pop();
				while (!shrunkHelper.isEmpty() && last.equals(shrunkHelper.peek())) {
					popCount++;
					shrunkHelper.pop();
				}
				if (count + popCount - 1 >= burstLength) {
					i = next - 1;
					continue;
				} else {
					while (popCount >= 0) {
						shrunkHelper.push(last);
						popCount--;
					}
				}

			} else {
				shrunkHelper.push(tmp);
			}

		}

		return new ArrayList<>(shrunkHelper);
	}

}

