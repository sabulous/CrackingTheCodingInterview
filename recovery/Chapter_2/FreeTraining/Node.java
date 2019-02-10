package Chapter_2.FreeTraining;/*
    Muhammed Sabri Sahin
    13-Jan-19
    Chapter_2.FreeTraining
*/

public class Node {
    public Integer data;
    public Node next;

    public Node() {
        this.data = null;
        next = null;
    }
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
