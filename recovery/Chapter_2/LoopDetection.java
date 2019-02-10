/*
    Muhammed Sabri Sahin
    18-Jan-19
    Chapter_2

    Cracking the Coding Interview - Question 2.8
*/
package Chapter_2;

import Chapter_2.FreeTraining.LoopingList;
import Chapter_2.FreeTraining.Node;

import java.util.HashSet;
import java.util.Set;

public class LoopDetection {
    public static void main(String args[]) {
        LoopingList list = new LoopingList(new int[]{1,2,3,4,5,6,7,8});
        Node runner = list.head;

        Set<Node> set = new HashSet<>();

        while(runner != null) {
            set.add(runner);
            System.out.print(runner.data + "->");
            if(set.contains(runner.next)) {
                System.out.println(runner.next.data);
                System.out.println("intersection node : " + runner.next.data);
                break;
            }
            runner = runner.next;
        }
    }
}
