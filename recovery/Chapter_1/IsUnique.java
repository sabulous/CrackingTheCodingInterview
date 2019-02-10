/*
    Muhammed Sabri Sahin
    06.01.2019
    Cracking the Coding Interview - Question 1.1
 */
package Chapter_1;

import java.util.HashMap;
import java.util.Scanner;

public class IsUnique {
    public static void main(String args[])
    {
        String input = readInput();
        checkDuplicateLetters(input);
    }

    private static HashMap<Character, Integer> checkDuplicateLetters(String input) {
        if(input != null && input != "") {
            char[] inputArray = input.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for(Character ch : inputArray) {
                if(map.containsKey(ch)) {
                    System.out.println("There is a duplicate char '" + ch + "'");
                    return null;
                } else {
                    map.put(ch, 1);
                }
            }
        } else {
            System.out.println("The string is either null or empty.");
        }
        System.out.println("The string is unique, no duplicate characters found.");
        return null;
    }

    private static String readInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
