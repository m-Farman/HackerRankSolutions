import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int noOps = sc.nextInt();
        BitSet[] bSet = new BitSet[] { new BitSet(size), new BitSet(size) };
        for (int i = 0; i < noOps; i++) {
            switch (sc.next()) {
            case "AND":
                bSet[sc.nextInt() - 1].and(bSet[sc.nextInt() - 1]);
                break;
            case "OR":
                bSet[sc.nextInt() - 1].or(bSet[sc.nextInt() - 1]);
                break;
            case "XOR":
                bSet[sc.nextInt() - 1].xor(bSet[sc.nextInt() - 1]);
                break;
            case "SET":
                bSet[sc.nextInt() - 1].set(sc.nextInt());
                break;
            case "FLIP":
                bSet[sc.nextInt() - 1].flip(sc.nextInt());
                break;
            default:
                break;
            }
            System.out.println(bSet[0].cardinality() + " " + bSet[1].cardinality());
        }
    }
}


