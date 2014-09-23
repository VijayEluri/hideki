import java.util.*;

public class PrintAllRootToLeafPaths
{
    static class Node {
        public Node left  = null;
        public Node right = null;
        public int  value = 0;

        public Node(int v){
            value = v;
        }

        public String toString(){
            return String.valueOf(value);
        }
    }    
    

    public static void printAllRootToLeafPaths(Node node){
        Stack<Node> stack = new Stack<Node>();
        _printAllRootToLeafPaths(node, stack);
        
    }

    private static void _printAllRootToLeafPaths(Node node, Stack<Node> stack){
        stack.push(node);
        if(node.left == null && node.right == null)
            _printRootToLeafPath(stack);
        if(node.left != null)
            _printAllRootToLeafPaths(node.left, stack);
        if(node.right != null)
            _printAllRootToLeafPaths(node.right, stack);

        stack.pop();
    }

    private static void _printRootToLeafPath(Stack<Node> stack){
        for(int i = 0; i < stack.size(); i++){
            if(i == 0)
                System.out.print(stack.elementAt(i));
            else
                System.out.print(" => " + stack.elementAt(i));
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);        
        //root.right.left = new Node(6);
        //root.right.right = new Node(7);
        printAllRootToLeafPaths(root);
        System.out.println("expected:");
        System.out.println("1 -> 2 -> 4");
        System.out.println("1 -> 2 -> 5");
        System.out.println("1 -> 3");

    }
}