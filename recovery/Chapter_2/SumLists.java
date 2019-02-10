/*
    Muhammed Sabri Sahin
    17-Jan-19
    Chapter_2

    Cracking the Coding Interview - Question 2.6
*/
package Chapter_2;

import Chapter_2.FreeTraining.Node;
import Chapter_2.FreeTraining.SinglyLinkedList;

import static Chapter_2.KthToLast.generateLinkedList;
import static Chapter_2.RemoveDups.printList;

public class SumLists {
    public static void main(String args[]) {
        SinglyLinkedList list1 = generateLinkedList(4, 10);
        SinglyLinkedList list2 = generateLinkedList(4, 10);
        printList(list1);
        printList(list2);

        int revSum = 0;
        revSum += reverseSum(list1.head);
        revSum += reverseSum(list2.head);
        System.out.println("Reverse sum is " + revSum);

        int fwdSum = 0;
        fwdSum += forwardSum(list1.head);
        fwdSum += forwardSum(list2.head);
        System.out.println("Forward sum is " + fwdSum);

        int intendedRevSum = intendedReverseSum(list1, list2);
        int intendedFwdSum = intendedForwardSum(list1, list2);

        System.out.println("Intended function implementation results :");
        System.out.println("Fwd sum = " + intendedFwdSum);
        System.out.println("Rev sum = " + intendedRevSum);
    }

    private static int intendedForwardSum(SinglyLinkedList list1, SinglyLinkedList list2) {
        return forwardSum(list1.head) + forwardSum(list2.head);
    }

    private static int intendedReverseSum(SinglyLinkedList list1, SinglyLinkedList list2) {
        return reverseSum(list1.head) + reverseSum(list2.head);
    }

    private static int forwardSum(Node node) {
        double multiplier = 1;
        double sum = 0;
        boolean mandal = false;
        while(node != null) {
            if(node.data != 0)
                mandal = true;
            sum += multiplier * node.data;
            if(mandal && node.next != null)
                multiplier /= 10;
            node = node.next;
        }
        sum = sum * (1/multiplier);
        return (int) sum;
    }

    private static int reverseSum(Node node) {
        int multiplier = 1;
        int sum = 0;
        while(node != null) {
            sum = sum + node.data * multiplier;
            node = node.next;
            multiplier = multiplier * 10;
        }
        return sum;
    }
}
