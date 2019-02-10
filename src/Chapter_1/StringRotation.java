/*
    Muhammed Sabri Sahin
    13-Jan-19
    Chapter_1

    Cracking the Coding Interview - Question 1.9
*/
package Chapter_1;

import java.util.Scanner;

public class StringRotation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string 1...");
        String s1 = sc.nextLine();
        System.out.println("Enter string 2...");
        String s2 = sc.nextLine();
        System.out.println("String 2 is a rotation of string 1: " + isSubstring(s1, s2));
    }

    static boolean isSubstring(String s1, String s2) {
        // if the lengths do not match or these are empty strings return false
        if(s1.length() != s2.length() || s1.isEmpty() || s2.isEmpty())
            return false;

        // otherwise double s1 and look for s2 in it
        StringBuilder s = new StringBuilder(s1);
        s.append(s1);
        return s.toString().contains(s2);
    }
}
