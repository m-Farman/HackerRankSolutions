//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
        HashMap<String,Integer> contact=new HashMap<String,Integer>();
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
            contact.put(name,phone);
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
            if(contact.containsKey(s)){
                System.out.println(s+"="+contact.get(s));
            }else{
             System.out.println("Not found");   
            }
		}
	}
}




