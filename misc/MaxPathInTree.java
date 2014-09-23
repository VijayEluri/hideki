import java.util.*;

/**
 *  find the depth of binary tree / maximum path in tree
 */
public class MaxPathInTree
{
    static class Node {
        public Node   left  = null;
        public Node   right = null;
        public String value = null;

        public Node(String v){
            value = v;
        }

        public String toString(){
            return value;
        }
    }

    public static int maxPathInTree(Node node, int level){
        int leftLevel = level;
        int rightLevel = level;
        if(node.left!=null)
            leftLevel = maxPathInTree(node.left, level + 1);
        if(node.right!=null)
            rightLevel = maxPathInTree(node.right, level + 1);    
        return Math.max(leftLevel, rightLevel);   
    }
    

    public static void main(String[] args)
    {
        Node root = new Node("3");
        root.left = new Node("9");
        root.right = new Node("20");
        root.right.left = new Node("15");
        root.right.right = new Node("7");
        System.out.println(maxPathInTree(root, 0));
    }
}