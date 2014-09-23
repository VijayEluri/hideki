import java.util.*;

public class VerticalSumInBinaryTree
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
    
    public static void verticalSumInBinaryTree(Node node){
        Map<Integer, Integer> verticalSums = new HashMap<Integer, Integer>();
        _verticalSumInBinaryTree(node, 0, verticalSums);


        List<Integer> list = new ArrayList<Integer>(verticalSums.keySet());
        Collections.sort(list);
        for(Integer key : list){
            System.out.print(verticalSums.get(key) + " ");
        }
        System.out.println();
    }
    public static void _verticalSumInBinaryTree(Node node, int vertical, Map<Integer, Integer> verticalSums){
        if(verticalSums.containsKey(vertical))
            verticalSums.put(vertical, verticalSums.get(vertical) + node.value);
        else
            verticalSums.put(vertical, node.value);

        if(node.left != null)
            _verticalSumInBinaryTree(node.left, vertical - 1, verticalSums);
        if(node.right != null)
            _verticalSumInBinaryTree(node.right, vertical + 1, verticalSums);
    }


    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);        
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        verticalSumInBinaryTree(root);
        System.out.println("expected 4, 2, 12, 3 and 7");
        // expected 4, 2, 12, 3 and 7
    }
}