import java.util.*;

/**
 *  find the depth of binary tree / maximum path in tree
 */
public class VerifyBinaryTree
{
    static class Node {
        public Node   left  = null;
        public Node   right = null;
        public int    value = 0;

        public Node(int v){
            value = v;
        }

        public String toString(){
            return String.valueOf(value);
        }
    }
    
    public static boolean isValidBinaryTree(Node node){
        return _isValidBinaryTree(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean _isValidBinaryTree(Node node, int min, int max){
        if(node.value < min || node.value > max)
            return false;
        if(node.left != null)
            if(!_isValidBinaryTree(node.left, min, node.value))
                return false;
        if(node.right != null)
            if(!_isValidBinaryTree(node.right, node.value, max))
                return false;            
        return true;
    }
    public static void main(String[] args)
    {
        // valid
        Node root        = new Node(5);
        root.left        = new Node(3);
        root.right       = new Node(9);
        root.left.left   = new Node(1);
        root.left.right  = new Node(4);
        root.right.left  = new Node(7);
        root.right.right = new Node(10);
        System.out.println(isValidBinaryTree(root)); // true

        // invalid
        root             = new Node(5);
        root.left        = new Node(3);
        root.right       = new Node(9);
        root.left.left   = new Node(1);
        root.left.right  = new Node(6);
        root.right.left  = new Node(7);
        root.right.right = new Node(10);
        System.out.println(isValidBinaryTree(root)); // false
    }
}
/*
Valid
    5
  3   9
1  4 7 10

InValid
   5
 3    9
1 6 7  10
*/