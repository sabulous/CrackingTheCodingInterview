/*
    Muhammed Sabri Sahin
    06.01.2019
    Cracking the Coding Interview - Question 1.3
*/
package Chapter_1;

import java.util.Scanner;

public class URLify {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // strict example input:"Mr John Smith ", 13
        String input = readInput();
        Integer delimitAt = input.lastIndexOf("\", "); // find the index of delimiter

        String parsed = input.substring(1, delimitAt);  // parse the string in quotation marks
        Integer trueLength = Integer.parseInt(input.substring(delimitAt + 3)); // parse the exact str length given

        System.out.println(parsed.substring(0, trueLength).replaceAll(" ", "%20"));
    }

    private static String readInput() {
        return sc.nextLine();
    }
}
