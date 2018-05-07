import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

     static HashMap<String,Integer> stringCount=new HashMap<String,Integer>();
    /*
     * Complete the findSuffix function below.
     */
    static int findSuffix(HashMap collections, String queryString) {
        
        if(collections.get(queryString)!=null){
            return (int) collections.get(queryString);    
        }
        
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String[] strings = new String[stringsCount];

        for (int stringsItr = 0; stringsItr < stringsCount; stringsItr++) {
            String stringsItem = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            strings[stringsItr] = stringsItem;
        }

        
         for(int i=0;i<stringsCount;i++)
	        {
	        	if (stringCount.containsKey(strings[i])) {
	        		stringCount.put(strings[i], stringCount.get(strings[i])+1);
				}else {
					stringCount.put(strings[i], 1);
				}
	            
	        }  
        
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int qItr = 0; qItr < q; qItr++) {
            String queryString = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int res = findSuffix(stringCount, queryString);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

