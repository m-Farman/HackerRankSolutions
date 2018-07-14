import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pickingNumbers function below.
    static int pickingNumbers(int[] a) {

        HashMap<Integer,Integer> nos=new HashMap<Integer,Integer>();
        int maxOcc = 0;
        for(int i=0;i < a.length; i++){
            if(!nos.containsKey(a[i])){
                nos.put(a[i],1);
            }else{
                nos.put(a[i],nos.get(a[i])+1);
            }
            if(maxOcc < nos.get(a[i])){
                maxOcc = nos.get(a[i]);
            }
        }
       ArrayList<Integer> keys= new ArrayList(nos.keySet());
        Collections.sort(keys);
        int max=0, sum =0;
        for(int i=0;i< keys.size()-1;i++){
            if(keys.get(i+1) - keys.get(i) == 1){
                sum = nos.get(keys.get(i+1)) + nos.get(keys.get(i));
               if(max < sum){
                    max=sum;
                }    
            }
        }
        
         if((nos.size() >= 1 && max == 0) || maxOcc > max){
        	 return maxOcc;
        }
        
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int a[] = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

