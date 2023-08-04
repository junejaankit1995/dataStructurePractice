package sort.practice.helper;

public class Node {

    public int data;

    public Node next;

    public Node(int key) {
        this.data = key;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}