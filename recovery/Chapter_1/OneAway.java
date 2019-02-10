/*
    Muhammed Sabri Sahin
    08-Jan-19
    Chapter_1

    Cracking the Coding Interview - Question 1.5
*/
package Chapter_1;

import java.util.Scanner;

public class OneAway {
    public static void main(String args[]) {
        String str1 = readInput();
        String str2 = readInput();

        System.out.println(isOneReplaceAway(str1, str2)
                || isOneInsertAway(str1, str2)
                || isOneDeleteAway(str1, str2));
    }

    private static boolean isOneDeleteAway(String str1, String str2) {
        return isOneInsertAway(str2, str1);
    }

    private static boolean isOneInsertAway(String str1, String str2) {
        if(str2.length() != str1.length() + 1) {
            return false;
        } else {
            Integer len1 = str1.length(); // short string length
            Integer len2 = str2.length(); // long string length
            boolean oneDifferenceDetected = false;
            for(int index1 = 0, index2 = 0; index1 < len1 && index2 < len2; index1++, index2++) {
                if(str1.charAt(index1) != str2.charAt(index2)) {
                    if(oneDifferenceDetected)
                        return false;
                    else {
                        oneDifferenceDetected = true;
                        index1--;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isOneReplaceAway(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        else {
            Integer len = str1.length();
            boolean oneReplacementDetected = false;
            for(int index = 0; index < len; index++) {
                if(str1.charAt(index) != str2.charAt(index)) {
                    if(oneReplacementDetected)
                        return false;
                    else
                        oneReplacementDetected = true;
                }
            }
        }
        return true;
    }

    private static String readInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
