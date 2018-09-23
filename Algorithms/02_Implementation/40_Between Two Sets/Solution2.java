import java.util.Scanner;

public class Solution2{
    private static Scanner reader = new Scanner(System.in);
    
    public static boolean findInA(int[]a,int element){
		int n=a.length;
		
		for(int i=0;i<n;i++){
			if(element%a[i]!=0){
				return false;
			}
		}
		return true;
	}
    
	public static boolean findInB(int[]b,int element){
		int n=b.length;
		
		for(int i=0;i<n;i++){
			if(b[i]%element!=0){
				return false;
			}
		}
		return true;
	}
    
    public static void main(String[] args) {
		int n = reader.nextInt(), m = reader.nextInt(), max = 1, min = 100, compt = 0;
		int[] a = new int[n];
		int[] b = new int[m];

		for (int i = 0; i < n; i++) {
			a[i] = reader.nextInt();
			max = max < a[i] ? a[i] : max;
		}
		for (int i = 0; i < m; i++) {
			b[i] = reader.nextInt();
			min = min < b[i] ? min : b[i];
		}
		for (int i = max; i <= min; i++) {
			if (findInA(a,i) && findInB(b,i)) {
				compt++;
			}
		}
		System.out.println(compt);
	}
}
