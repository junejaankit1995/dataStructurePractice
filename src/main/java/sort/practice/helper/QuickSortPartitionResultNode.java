package sort.practice.helper;

public class QuickSortPartitionResultNode {

    public Node lHead;
    public Node rHead;
    public Node pivot;

    public QuickSortPartitionResultNode(Node lNode, Node piNode, Node rNode) {
        lHead = lNode;
        rHead = rNode;
        pivot = piNode;
    }


}
