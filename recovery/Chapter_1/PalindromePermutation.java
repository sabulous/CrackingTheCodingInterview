/*
    Muhammed Sabri Sahin
    07-Jan-19
    Cracking the Coding Interview - Question 1.4

    Description :   Checks given console input to determine whether a palindrome
                    could be formed using its letters or not.

                    Case insensitive (whole input gets lowercased)
                    Whitespaces are ignored
*/
package Chapter_1;

import java.util.HashMap;
import java.util.Scanner;

public class PalindromePermutation {

    static Scanner sc = new Scanner(System.in);
    static char[] input;
    static HashMap<Character, Integer> charCount;

    public static void main(String args[]) {
        readInput();
        System.out.println("Is palindromable? " + isPalindrome());
    }

    private static boolean isPalindrome() {
        countChars();
        return checkPalindromability();
    }

    //checks if an input is palindrome or not (whitespaces are ignored, case sensitive)
    private static boolean checkPalindromability() {
        boolean oddEncountered = false; // assume any input is palindrome at first (zero occurrences of any chars)

        for(Integer count : charCount.values()) {
            if(count % 2 == 1) {
                if(oddEncountered) { // there has been one odd char count already, so second one means a non-palindrome
                    return false;
                } else {
                    oddEncountered = true;
                }
            }
        }
        return true;
    }

    private static void countChars() {
        if(input.length == 0) {
            System.out.println("Information : Input given is of length zero.");
        } else {
            charCount = new HashMap<>();
            for(Character ch : input) {
                if(ch != ' ') { // whitespaces are ignored
                    Integer count = 0;
                    if(charCount.containsKey(ch)) { // set the current count if there already exists an entry
                        count = charCount.get(ch);
                    }
                    charCount.put(ch, count + 1); // unless the key is found then new map entry will be as <char, 1>
                }
            }
        }
        return;
    }

    // read nextline input into a charArray
    private static void readInput() { input = sc.nextLine().toLowerCase().toCharArray(); }
}
