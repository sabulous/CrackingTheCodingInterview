/*
    Muhammed Sabri Sahin
    14-Jan-19
    Chapter_2

    Cracking the Coding Interview - Question 2.2
*/
package Chapter_2;

import Chapter_2.FreeTraining.Node;
import Chapter_2.FreeTraining.SinglyLinkedList;

import java.util.Random;
import java.util.Scanner;

import static Chapter_2.RemoveDups.printList;

public class KthToLast {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of list to generate : ");
        Integer length = sc.nextInt();
        SinglyLinkedList list = generateLinkedList(length, 101);
        printList(list);
        System.out.print("Enter k to find out kth to last element : ");
        Integer k = sc.nextInt();
        Node head = list.head;
        Node runner = head; // this pointer goes to the last node
        Node theNode = head; // this is the pointer that will show the kth element to last

        for(int i = 0; i < k-1; i++) {
            if(runner.next != null)
                runner = runner.next;
            else if(i != k - 2) {
                System.out.println("ERROR: List had got less than " + k + "nodes.");
            }
        }

        while(runner.next != null) {
            runner = runner.next;
            theNode = theNode.next;
        }
        System.out.println(k + "th to last element of the list is " + theNode.data);
    }


    static SinglyLinkedList generateLinkedList(int nodeCount, int bound) {
        Node head = new Node();
        Node node = head;
        for(int i = 0; i < nodeCount; i++) {
            Random random = new Random();
            node.data = random.nextInt(bound);
            if(i != nodeCount-1) {
                node.next = new Node();
                node = node.next;
            }
        }
        return new SinglyLinkedList(head);
    }
}
