/*
    Muhammed Sabri Sahin
    15-Jan-19
    Chapter_2

    Cracking the Coding Interview - Question 2.3
*/
package Chapter_2;

import Chapter_2.FreeTraining.Node;
import Chapter_2.FreeTraining.SinglyLinkedList;

import java.util.Random;
import java.util.Scanner;

import static Chapter_2.KthToLast.generateLinkedList;
import static Chapter_2.RemoveDups.printList;

public class DeleteMiddleNode {
    public static void main(String args[]) {
        int listLength = new Random().nextInt(11) + 3;
        SinglyLinkedList list = generateLinkedList(listLength, 101);
        System.out.println("bound = " + listLength);
        System.out.println("Generated list :");
        printList(list);

        if(listLength < 3) return;
        else System.out.print("Enter a number in the middle of the list order : ");

        Scanner sc = new Scanner(System.in);
        int middle = sc.nextInt();

        if(middle <= 1 || middle >= listLength) return;
        else {
            Node node = list.head;
            for(int i = 0; i < middle - 1; i++) {
                node = node.next;
            }
            System.out.println("You picked : " + node.data);

            //node will be removed.

            deleteNode(list.head, node);
        }
    }

    private static void deleteNode(Node head, Node node) {
        Node runner = head;
        while(runner.next != node) {
            runner = runner.next;
        }
        runner.next = runner.next.next;

        System.out.println("Modified list :");
        printList(new SinglyLinkedList(head));
    }
}
