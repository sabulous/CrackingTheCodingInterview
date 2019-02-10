/*
    Muhammed Sabri Sahin
    16-Jan-19
    Chapter_2

    Cracking the Coding Interview - Question 2.4
*/
package Chapter_2;

import Chapter_2.FreeTraining.Node;
import Chapter_2.FreeTraining.SinglyLinkedList;

import java.util.Scanner;

import static Chapter_2.KthToLast.generateLinkedList;
import static Chapter_2.RemoveDups.printList;

public class Partition {
    public static void main(String args[]) {
        int listLength = 10;
        SinglyLinkedList list = generateLinkedList(listLength, 101);
        System.out.println("Generated list :");
        printList(list);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value to partition the other nodes : ");
        int partition = sc.nextInt();

        if(list.head != null)
            partitionList(list, partition);
    }

    private static void partitionList(SinglyLinkedList list, int partition) {
        Node head = list.head;
        Node runner = head;
        while(runner.next != null && runner.next.data < partition) {
            runner = runner.next;
        }
         Node picker = runner;
        while(picker.next != null) {
            if(picker.next.data >= partition) picker = picker.next;
            else {
                Node moveable = picker.next;
                picker.next = picker.next.next;
                moveable.next = runner.next;
                runner.next = moveable;
                runner = runner.next;
            }
        }

        System.out.println("Partitioned list :");
        printList(new SinglyLinkedList(head));
    }
}
