import java.util.*;

/**
 * print the tree in level order but using DFS
 */
public class TreeTraversal
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
    public static void printLevelOrderDFS(Node root){
        Map<Integer, Queue<String>> map = new HashMap<Integer, Queue<String>>();
        int level = traverseDFS(root, 0, map);
        for(int i = 0; i <= level; i++){
            System.out.println(map.get(i));
        }
    }
    private static int traverseDFS(Node node, int level, Map<Integer, Queue<String>> map)
    {
        if(map.containsKey(level)){
            Queue<String> q = map.get(level);
            q.add(node.value);
        }else{
            Queue<String> q = new LinkedList<String>();
            q.add(node.value);
            map.put(level, q);
        }

        int leftLevel = level;
        int rightLevel = level;
        if(node.left!=null)
            leftLevel = traverseDFS(node.left, level + 1, map);
        if(node.right!=null)
            rightLevel = traverseDFS(node.right, level + 1, map);

        return Math.max(leftLevel, rightLevel);
    }

    public static void printLevelOrderBFS(Node root){
        if(root==null) return;

        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel    = new LinkedList<Node>();
        currentLevel.add(root);
        
        while(!currentLevel.isEmpty()){
            Node node = currentLevel.remove();
            System.out.print(node + " ");
            if(node.left != null){
                nextLevel.add(node.left);
            }
            if(node.right != null){
                nextLevel.add(node.right);
            }
            if(currentLevel.isEmpty()){
                currentLevel = nextLevel;
                nextLevel    = new LinkedList<Node>();
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node("3");
        root.left = new Node("9");
        root.right = new Node("20");
        root.right.left = new Node("15");
        root.right.right = new Node("7");
        printLevelOrderBFS(root);
        printLevelOrderDFS(root);
    }
}