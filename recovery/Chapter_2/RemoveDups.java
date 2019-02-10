package Chapter_2;/*
    Muhammed Sabri Sahin
    13-Jan-19

    Cracking the Coding Interview - Question 2.1
*/

import Chapter_2.FreeTraining.Node;
import Chapter_2.FreeTraining.SinglyLinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveDups {
    public static void main(String args[]) {
        SinglyLinkedList list = createList();
        printList(list);
        SinglyLinkedList uniqueList = removeDuplicates(list);
        printList(uniqueList);
    }

    private static SinglyLinkedList removeDuplicates(SinglyLinkedList list) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        Node node = list.head;
        Integer count = 1;
        /* store occurrence of every node into the map */
        while(node != null) {
            count = 1;
            if(occurrence.get(node.data) != null) {
                count = occurrence.get(node.data) + 1;
            }
            occurrence.put(node.data, count);
            node = node.next;
        }
        System.out.println(occurrence.toString());

        Node head = list.head;
        while(head != null && occurrence.get(head.data) > 1) {
            Integer cnt = occurrence.get(head.data) - 1;
            occurrence.put(head.data, cnt);
            head = head.next;
        }

        node = head;

        while(node != null && node.next != null) {
            if(occurrence.get(node.next.data) > 1) {
                Integer cnt = occurrence.get(node.next.data) - 1;
                occurrence.put(node.next.data, cnt);
                node.next = node.next.next;
            }
            node = node.next;
        }
        list.head = head;
        return list;
    }

    public static void printList(SinglyLinkedList list) {
        Node n = list.head;
        while(n != null) {
            System.out.print(n.data);
            if(n.next != null)  System.out.print("->");
            n = n.next;
        }
        System.out.println();
    }

    private static SinglyLinkedList createList() {
        Node head = new Node();
        SinglyLinkedList list = new SinglyLinkedList(head);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes :");
        Integer nodeCount = sc.nextInt();
        Node node = null;
        for(int i = 1; i <= nodeCount; i++) {
            if(i == 1) {
                System.out.print("Head node : ");
                head.data = sc.nextInt();
                node = head;
            } else {
                System.out.print("Node " + i + " : ");
                node.next = new Node(sc.nextInt());
                node = node.next;
            }
        }
        return list;
    }
}
