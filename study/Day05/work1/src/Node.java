public class Node {
    private int _value;
    private Node _left;
    private Node _right;

    public Node(){
        _left = _right = null;
    }

    public Node(int value){
        this.setValue(value);
        _left = _right = null;
    }

    public Node getLeft(){
        return _left;
    }

    public Node getRight(){
        return _right;
    }

    public int getValue(){
        return _value;
    }

    public void setLeft(Node left){
        _left = left;
    }

    public void setRight(Node right){
        _right = right;
    }

    public void setValue(int value){
        _value = value;
    }
}
