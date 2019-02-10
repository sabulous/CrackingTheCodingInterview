package Chapter_2.FreeTraining;/*
    Muhammed Sabri Sahin
    18-Jan-19
    Chapter_2.FreeTraining
*/

import java.util.Random;

public class LoopingList extends SinglyLinkedList {
    public Node head;
    public int length;
    public LoopingList(int[] arr) {
        super(arr);
        this.head = super.head;
        this.length = arr.length;
        Node runner = head;
        while(runner.next != null) {
            runner = runner.next;
        }
        Random random = new Random();
        int intersectionIndex = random.nextInt(length-1);
        Node intersectionNode = head;
        for(int i = 0; i < intersectionIndex; i++) {
            intersectionNode = intersectionNode.next;
        }
        runner.next = intersectionNode;
    }
}
