
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/*find all the number containing 1,2,3 in it and output the numbers in ascending order
 * */
public class Solution {

	public static void main(String[] args) {
		int[] arr = { 345671, 43218, 12345, 1456 };

		System.out.println(Arrays.toString(arr));
		System.out.println(findQualifiedNumbers(arr));
	}

	static String findQualifiedNumbers(int[] numberArray) {

		ArrayList<Integer> requiredNumber = new ArrayList<>();
		for (int i = 0; i < numberArray.length; i++) {
			if (checkIf123Present(numberArray[i])) {
				requiredNumber.add(numberArray[i]);
			}
		}

		if (requiredNumber.size() == 0) {
			return "-1";
		} else {
			return requiredNumber.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
		}

	}

	private static boolean checkIf123Present(int number) {

		int n = number;
		int d = 0;
		HashSet<Integer> testerOf123 = new HashSet<>();
		while (n > 0) {
			d = n % 10;
			if (d >= 1 && d <= 3) {
				testerOf123.add(d);
			}
			n /= 10;
		}

		return testerOf123.size() == 3 ? true : false;
	}

}

