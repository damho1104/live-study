import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;
    private String traverseResult;
    private final Queue<Node> queueForBFS;

    public BinaryTree(){
        root = null;
        traverseResult = "";
        queueForBFS = new LinkedList<Node>();
    }

    public BinaryTree(int value){
        root = new Node(value);
        traverseResult = "";
        queueForBFS = new LinkedList<Node>();
    }

    public Node getRoot()
    {
        return root;
    }

    public void insert(int value){
        root = insertRecursive(root, value);
    }

    public String getTraverseResult(){
        return traverseResult;
    }

    public void bfs(Node node){
        if(node.getLeft() != null) {
            queueForBFS.add(node.getLeft());
        }
        if(node.getRight() != null) {
            queueForBFS.add(node.getRight());
        }
        traverseResult += String.format("%d ", node.getValue());
        if(!queueForBFS.isEmpty()) {
            bfs(queueForBFS.remove());
        }
    }

    public void dfs(Node node){
        if(node.getLeft() != null){
            dfs(node.getLeft());
        }
        traverseResult += String.format("%d ", node.getValue());
        if(node.getRight() != null){
            dfs(node.getRight());
        }
    }

    private Node insertRecursive(Node currentNode, int value){
        if(currentNode == null){
            return new Node(value);
        }
        else{
            if(currentNode.getValue() > value){
                currentNode.setLeft(insertRecursive(currentNode.getLeft(), value));
            }
            if(currentNode.getValue() < value){
                currentNode.setRight(insertRecursive(currentNode.getRight(), value));
            }
        }
        return currentNode;
    }
}
