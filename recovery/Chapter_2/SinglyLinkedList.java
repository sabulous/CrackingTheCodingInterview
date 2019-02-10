/*
    Muhammed Sabri Sahin
    13-Jan-19
    Chapter_2.FreeTraining
*/
package Chapter_2.FreeTraining;

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList(Node head) {
       this.head = head;
    }

    public SinglyLinkedList(int arr[]) {
        if(arr.length > 0) {
            this.head = new Node(arr[0]);
            Node node = this.head;
            for(int i = 1; i < arr.length; i++) {
                node.next = new Node(arr[i]);
                node = node.next;
            }
        }
    }
}
