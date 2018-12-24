import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sumOfLeaf = 0;

    public int getResult() {
        return sumOfLeaf;
    }

    public void visitNode(TreeNode node) {
        // implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        sumOfLeaf += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private final int mod = 1000000007;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % mod;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % mod;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNodeSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        return Math.abs(evenDepthNodeSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNodeSum += node.getValue();
        }

    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.GREEN)) {
            greenLeavesSum += leaf.getValue();
        }
    }
}

public class Solution {
    private static int[] values;
    private static Color[] colors;
    private static HashMap<Integer, Set<Integer>> edges = new HashMap<>();

    public static Tree solve() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            values = new int[n];
            colors = new Color[n];
            String[] valueInput = br.readLine().split(" ");
            String[] colorInput = br.readLine().split(" ");
            for (int i = 0; i < values.length; i++) {
                values[i] = Integer.parseInt(valueInput[i]);
                colors[i] = colorInput[i].equals("0") ? Color.RED : Color.GREEN;
            }
            if (n == 1) {
                return new TreeLeaf(values[0], colors[0], 0);
            }

            for (int i = 0; i < n - 1; i++) {
                valueInput = br.readLine().split(" ");
                int u = Integer.parseInt(valueInput[0]);
                int v = Integer.parseInt(valueInput[1]);

                if (!edges.containsKey(u)) {
                    edges.put(u, new HashSet<Integer>());
                }
                if (!edges.containsKey(v)) {
                    edges.put(v, new HashSet<Integer>());
                }
                edges.get(u).add(v);
                edges.get(v).add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Tree root = new TreeNode(values[0], colors[0], 0);
        for (Integer connectedNode : edges.get(1)) {
            edges.get(connectedNode).remove(1);
            connectEdge(root, connectedNode);
        }

        return root;
    }

    private static void connectEdge(Tree parent, Integer connectedNode) {

        if (edges.get(connectedNode).size() == 0) {
            ((TreeNode) parent).addChild(
                    new TreeLeaf(values[connectedNode - 1], colors[connectedNode - 1], parent.getDepth() + 1));
            return;
        }

        Tree node = new TreeNode(values[connectedNode - 1], colors[connectedNode - 1], parent.getDepth() + 1);
        ((TreeNode) parent).addChild(node);
        for (Integer child : edges.get(connectedNode)) {
            edges.get(child).remove(connectedNode);
            connectEdge(node, child);
        }

    }


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}
