import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the dynamicArray function below.
     */
    static int[] dynamicArray(int n, int[][] queries) {
      
        
        ArrayList<Integer> output=new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> seq = new ArrayList<ArrayList<Integer>>(n);
		for (int i = 0; i < n; i++) {
			seq.add(new ArrayList<Integer>());
		}
	
		int lastNumber=0,x=0,y=0,seqIndex=0;
		for (int i = 0; i < queries.length; i++) {

				x=queries[i][1];
				y=queries[i][2];
				seqIndex=(x^lastNumber)%n;
			if (queries[i][0]==1) {
				seq.get(seqIndex).add(y);	
			}else {
				lastNumber=seq.get(seqIndex).get(y%seq.get(seqIndex).size());
				output.add(lastNumber);
			}
		}

		int[] o=new int[output.size()];
		for (int i = 0; i < output.size(); i++) {
			o[i]=output.get(i);
		}
		return o;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[][] queries = new int[q][3];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = dynamicArray(n, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

