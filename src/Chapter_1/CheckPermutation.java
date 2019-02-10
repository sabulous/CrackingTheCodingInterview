/*
    Muhammed Sabri Sahin
    06.01.2019
    Cracking the Coding Interview - Question 1.2
 */
package Chapter_1;

import java.util.HashMap;
import java.util.Scanner;

public class CheckPermutation {
    public static void main(String args[]) {
        String input1 = readStringInput();
        String input2 = readStringInput();

        if(isPermutation(input1, input2)) {
            System.out.println("Yes, there is a permutation.");
        } else {
            System.out.println("No there is no permutation");
        }
    }

    private static boolean isPermutation(String input1, String input2) {
        if(input1.length() != input2.length()) return false;
        else {
            HashMap<Character, Integer> charCount = new HashMap<>();

            //  populate hashmap by iterating through first string
            char[] charArr = input1.toCharArray();
            for(Character ch : charArr) {
                Integer count = 0;
                if(charCount.containsKey(ch)) { count = charCount.get(ch); }
                charCount.put(ch, count + 1);
            }

            //  go over second string decrementing hashmap values upon encounter
            charArr = input2.toCharArray();
            for(Character ch : charArr) {
                Integer count;
                if(!charCount.containsKey(ch)) {
                    return false;
                } else if(charCount.get(ch) == 0) {
                    return false;
                } else {
                    count  = charCount.get(ch);
                    charCount.put(ch, count - 1);
                }
            }

            // final check on hashmap values :
            // if there are ones > 0 then less of that character is in input2,
            // there is no permutation
            for(Integer finalCharCount : charCount.values()) {
                if(finalCharCount > 0) return false;
            }
            return true;
        }
    }

    private static String readStringInput() {
        System.out.println("Enter an input string:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }
}
