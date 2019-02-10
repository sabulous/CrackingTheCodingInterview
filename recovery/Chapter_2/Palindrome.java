/*
    Muhammed Sabri Sahin
    17-Jan-19
    Chapter_2
*/
package Chapter_2;

import Chapter_2.FreeTraining.Node;
import Chapter_2.FreeTraining.SinglyLinkedList;

import java.util.Stack;

import static Chapter_2.KthToLast.generateLinkedList;
import static Chapter_2.RemoveDups.printList;

public class Palindrome {
    public static void main(String args[]) {
        //SinglyLinkedList list = generateLinkedList(2, 20);
        int arr[] = {10, 100, 2, 2, 100, 10};
        SinglyLinkedList list = new SinglyLinkedList(arr);
        printList(list);
        System.out.println("Is given list palindrome?");
        System.out.println(isPalindrome(list));
    }

    private static boolean isPalindrome(SinglyLinkedList list) {
        int len = findLength(list);
        if(len == 0 || len == 1) return true;

        Node node = list.head;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len/2; i++) {
            stack.push(node.data);
            node = node.next;
        }
        if(len % 2 == 1) node = node.next;
        while(node != null) {
            if(node.data != stack.pop())
                return false;
            node = node.next;
        }
        return true;
    }

    private static int findLength(SinglyLinkedList list) {
        int count = 0;
        Node node = list.head;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
