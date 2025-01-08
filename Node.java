public class Node {
    private Node next;
    private Node prev;
    private int data;

    //Constructors
    public Node () {
        next = null;
        prev = null;
        data = 0;
    }
    public Node (int x) {
        next = null;
        prev = null;
        data = x;
    }

    //Mutators
    public void setNext(Node x) {
        next = x;
        return;
    }
    public void setPrev(Node x) {
        prev = x;
        return;
    }
    public void setData(int x) {
        data = x;
        return;
    }

    //Accessors
    public Node getNext() {
        return next;
    }
    public Node getPrev() {
        return prev;
    }
    public int getData() {
        return data;
    }
}
